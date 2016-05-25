<?php

namespace BackOffice\BackOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use RayzerCoder\UserBundle\Entity\User;

class DefaultController extends Controller {

    public function homeAction() {
        $em = $this->getDoctrine()->getManager();



        $query = $em->createQuery("select count(c) as nbre from RayzerCoderUserBundle:User as c where c.connecte=1");

        $connectes = $query->getResult();
        $query1 = $em->createQuery("select c.username as nom, c.note as note from RayzerCoderUserBundle:User as c where c.username <> 'adminuser' order by c.note DESC ");

        $topnote = $query1->getResult();
        $subArray = array_slice($topnote, 0, 5);
        $query2 = $em->createQuery("select count(c) as nbr ,c.sexe as sexe from RayzerCoderUserBundle:User as c group by sexe ");

        $sexe = $query2->getResult();
        $query3 = $em->createQuery("select count(c) as nbr ,c.etat as et from RayzerCoderUserBundle:User as c group by et ");

        $etat = $query3->getResult();
        $query4 = $em->createQuery("select r   from FrontMNRSBundle:Reclamations as r where r.vu=0 ");

        $nbr_rec = $query4->getResult();
        return $this->render('BackOfficeBackOfficeBundle:Default:home.html.twig', array('connectes' => $connectes, 'topnote' => $subArray, 'sexe' => $sexe, 'etat' => $etat, 'nbr_rec' => $nbr_rec));
    }

    public function home2Action() {
        $em = $this->getDoctrine()->getManager();
        $query = $em->createQuery("select count(c)as nbre from RayzerCoderUserBundle:User as c where c.connecte=1");
        $connectes = $query->getResult();
        foreach ($connectes as $conn) {
            die($conn['nbre']);
        }
    }

    public function emailAction($email) {
        $Request = $this->getRequest();
        $subject = $Request->get("Subject");
        $contenu = $Request->get("cont");
        $message = \Swift_Message::newInstance()
                ->setSubject($subject)
                ->setFrom('covoiturage.1314.3a8@gmail.com')
                ->setTo($email)
                ->setBody($contenu);
        $this->get('mailer')->send($message);
        return $this->render('BackOfficeBackOfficeBundle:Default:envoi.html.twig');
    }

    public function impossibleAction() {
        return $this->render('BackOfficeBackOfficeBundle:Default:impossible.html.twig', array());
    }

    public function listeReclamationAction() {


        $em = $this->getDoctrine()->getManager();
        $query = $em->createQuery('select r from FrontMNRSBundle:Reclamations as r where r.vu=0 ');
        $entities = $query->getResult();

        return $this->render('BackOfficeBackOfficeBundle:Default:listeReclamation.html.twig', array(
                    'modeles' => $entities
        ));
    }

    public function userAction() {
//
//        $em = $this->container->get('Doctrine')->getEntityManager();
//        
//        $modeles = $em->getRepository('RayzerCoderUserBundle:User')->findAll();

        $em = $this->getDoctrine()->getManager();
        $query = $em->createQuery('select c from RayzerCoderUserBundle:User as c');
        $entities = $query->getResult();

        return $this->render('BackOfficeBackOfficeBundle:Default:utilisateur.html.twig', array(
                    'modeles' => $entities
        ));
    }

    public function showAction($id) {

        $em = $this->getDoctrine()->getManager();


        $entity = $em->getRepository('FrontMNRSBundle:Reclamations')->find($id);
        $entity->setVu(1);
        $em->persist($entity);
        $em->flush();

        return $this->render('BackOfficeBackOfficeBundle:Default:show.html.twig', array(
                    'entity' => $entity
        ));
    }

    public function covAction() {

        $em = $this->container->get('Doctrine')->getEntityManager();
        $modeles = $em->getRepository('FrontMNRSBundle:covoiturages')->findAll();

        return $this->render('BackOfficeBackOfficeBundle:Default:covoiturage.html.twig', array(
                    'modeles' => $modeles
        ));
    }

    public function addUserAction() {
        $cov = new User();
        $form = $this->container->get('Form.factory')->create(new \BackOffice\BackOfficeBundle\Form\CovoitureurForm(), $cov);

        $request = $this->getRequest();
        if ($request->getMethod() == "POST") {
            $form->bind($request); // recuperer les donnée saisie dans le formulaire
            if ($form->isValid()) {
                $em = $this->container->get('Doctrine')->getEntityManager();
                $cov->setDateEnregistrement(new \DateTime());
                $cov->setLastLogin(new \DateTime());
                $cov->setExpiresAt(new \DateTime());

                $em->persist($cov); // insérer $cov===dans la base de donnée ou plutot dans le cache
                $em->flush();

                return $this->redirect($this->generateUrl('back_office_userpage'));
            }
        } else {
            
        }

        return $this->render('BackOfficeBackOfficeBundle:default:ajoutUser.html.twig', array(
                    'Form' => $form->createView()
        ));
    }

    public function deletecovAction($id) {

        $em = $this->container->get('Doctrine')->getEntityManager();
        $modeles = $em->getRepository('RayzerCoderUserBundle:User')->find($id);
        $listcovoiturage = $em->getRepository('FrontMNRSBundle:covoiturages')->findBy(array('idCreateur' => $id));
        $listemessageEx = $em->getRepository('FrontMNRSBundle:Messages')->findBy(array('idDestinataire' => $id));
        $listemessageDes = $em->getRepository('FrontMNRSBundle:Messages')->findBy(array('idExpediteur' => $id));

        if ($listcovoiturage || $listemessageEx || $listemessageDes) {
            return $this->redirect($this->generateUrl('back_office_impossible_user'));
        } else {

            $em->remove($modeles);
            $em->flush();


            return $this->redirect($this->generateUrl('back_office_userpage'));
        }
    }

    public function updateUserAction($id) {

        $em = $this->container->get('Doctrine')->getEntityManager();
        $modeles = $em->getRepository('RayzerCoderUserBundle:User')->find($id);
        $form = $this->container->get('Form.factory')->create(new \BackOffice\BackOfficeBundle\Form\modifiercovoitureurForm, $modeles);
        $request = $this->getRequest();
        if ($request->getMethod() == "POST") {

            //a^pres le post

            $form->bind($request); // recuperer les donnée saisie dans le formulaire
            if ($form->isValid()) {

                $em->persist($modeles); // insérer dans la base de donnée ou plutot dans le cache
                $em->flush();

                return $this->redirect($this->generateUrl('back_office_userpage'));
            }
        } else {

            return $this->render('BackOfficeBackOfficeBundle:default:modifierCovoitureur.html.twig', array('Form' => $form->createView()));
        }
    }

    public function deletecovoiturageAction($id) {

        $em = $this->container->get('Doctrine')->getEntityManager();
        $modeles = $em->getRepository('FrontMNRSBundle:covoiturages')->find($id);



        $em->remove($modeles);
        $em->flush();


        return $this->redirect($this->generateUrl('back_office_covpage'));
    }

}
