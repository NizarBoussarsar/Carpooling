<?php

namespace Gestion\CovoiturageBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Front\MNRSBundle\Entity\Covoiturages;
use Front\MNRSBundle\Entity\Notifications;
use Front\MNRSBundle\Entity\Villes;
use Gestion\CovoiturageBundle\Form\CovoituragesForm;
use Gestion\CovoiturageBundle\Form\CovoituragesType;
use Doctrine\ORM\Query\ResultSetMapping;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of CovoituragesController
 *
 * @author Hhussein
 */
class CovoituragesController extends Controller {

    public function ListCovoituragesAction() {
        $em = $this->container->get('Doctrine')->getEntityManager();
        $Covoiturages = $em->getRepository('FrontMNRSBundle:Covoiturages')->findAll();
        return $this->render('GestionCovoiturageBundle:Covoiturages:index.html.twig', array(
                    'entities' => $Covoiturages
        ));
    }

    public function MesCovoituragesAction() {
        $idcovoitureurConnecte = $this->get('security.context')->getToken()->getUser()->getId();
        $em = $this->container->get('Doctrine')->getEntityManager();
        $query = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idcovoitureurConnecte);
        $queryy = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idcovoitureurConnecte);
        $notifications = $queryy->getResult();
        $messages = $query->getResult();
        $CovoitureurConnecte = $em->getRepository('RayzerCoderUserBundle:User')->findOneById($idcovoitureurConnecte);
        $Covoiturages = $em->getRepository('FrontMNRSBundle:Covoiturages')->findByidCreateur($CovoitureurConnecte);
        return $this->render('GestionCovoiturageBundle:Covoiturages:MesCovoiturages.html.twig', array(
                    'entities' => $Covoiturages,
                    'messages' => $messages,
                    'notifications' => $notifications
        ));
    }

    public function AjoutCovoiturageAction() {
        $em = $this->container->get('Doctrine')->getEntityManager();

        $idcovoitureurConnecte = $this->get('security.context')->getToken()->getUser()->getId();
        $query = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idcovoitureurConnecte);
        $queryy = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idcovoitureurConnecte);
        $notifications = $queryy->getResult();
        $messages = $query->getResult();
        $Covoiturage = new \Front\MNRSBundle\Entity\Covoiturages;

        $CovoitureurConnecte = $em->getRepository('RayzerCoderUserBundle:User')->findOneById($idcovoitureurConnecte);

        $form = $this->container->get('form.factory')->create(new CovoituragesForm(), $Covoiturage);
        $request = $this->getRequest();
        if ($request->getMethod() == "POST") {
            $form->bind($request); //recupereer les donnee au niveau formulaire 
            $Covoiturage->setIdCreateur($CovoitureurConnecte);
            $Covoiturage->setDateCreation(new \Datetime());
            $Covoiturage->setDateMiseajour(new \Datetime());
            $em->persist($Covoiturage); // INSERT fil cache 
            $em->flush(); // commit       validation de insertion    
            return $this->redirect($this->generateUrl('Mes_covoiturages')); // rederection ficher routing
        }

        return $this->render('GestionCovoiturageBundle:Covoiturages:new.html.twig', array(
                    'form' => $form->createView(),
                    'notifications' => $notifications,
                    'messages' => $messages
        ));
    }

    public function FindCovoiturageAction() {
        $em = $this->getDoctrine()->getManager();
        $Request = $this->getRequest();
        $covoiturages = new Covoiturages();
        $delegations = $this->FindgouvernoratAction();
        if ('GET' == $Request->getMethod()) {
            $search1 = $Request->get('search1');
            $search2 = $Request->get('search2');
            $d = $search1;
            $a = $search2;
            $query = $em->createQuery(
                            'SELECT DISTINCT c
                         FROM FrontMNRSBundle:Covoiturages c,FrontMNRSBundle:Villes v 
                         WHERE
                                ( v.id=c.idVilleDepart OR  v.id=c.idVilleArrivee )
                             AND   (v.gouvernorat LIKE :d OR  v.gouvernorat LIKE :a) '
                    )->setParameter('d', $d)
                    ->setParameter('a', $a);
            $covoiturages = $query->getResult();
            return $this->render('GestionCovoiturageBundle:Covoiturages:Rech.html.twig', array(
                        'entities' => $covoiturages,
                        'delegations' => $delegations
            ));
        }

        return $this->render('GestionCovoiturageBundle:Covoiturages:Rech.html.twig', array(
                    'entities' => $covoiturages,
                    'delegations' => $delegations
        ));
    }

    function FindaCovoiturageAction() {
        /* http://sf2.memosdedev.com/creer-une-requete-sql-native-dans-symfony2-avec-doctrine2.html
         * http://guidella.free.fr/General/symfony2DoctrineQueryLanguage.html
         */
        $em = $this->getDoctrine()->getManager();
        $rsm = new ResultSetMapping();
        $rsm->addEntityResult('FrontMNRSBundle:Covoiturages', 'c');
        $rsm->addFieldResult('c', 'id', 'id');
        $rsm->addFieldResult('c', 'titre', 'titre');
        $rsm->addFieldResult('c', 'description', 'description');
        //  $rsm->addFieldResult('c', 'id_createur', 'idCreateur');
        $rsm->addFieldResult('c', 'date_creation', 'dateCreation');
        $rsm->addFieldResult('c', 'heure_depart', 'heureDepart');
        $rsm->addFieldResult('c', 'date_depart', 'dateDepart');
        $rsm->addFieldResult('c', 'prix', 'prix');
        $rsm->addFieldResult('c', 'nombre_places', 'nombrePlaces');
        //   $rsm->addFieldResult('c', 'id_createur', 'nombrePlaces');


        $covoiturages = new Covoiturages();
        $Request = $this->getRequest();

        if ('POST' == $Request->getMethod()) {

            $search1 = $Request->get('search');

            $d = $search1;

            //SELECT c.id,c.titre,c.description,c.id_createur,c.date_creation,c.heure_depart,date_depart,c.prix,c.nombre_places        

            $query_search = "SELECT c.id,c.titre,c.description,c.id_createur,c.date_creation,c.heure_depart,date_depart,c.prix,c.nombre_places        
                             FROM covoiturages c
                             LEFT JOIN detours d ON ( c.id = d.id_covoiturage ) 
                             INNER JOIN villes ON ( villes.id = d.id_ville
                             OR c.id_ville_depart = villes.id
                             OR c.id_ville_arrivee = villes.id ) 
                             WHERE (villes.gouvernorat LIKE  '%" . $d . "%'
                             OR villes.delegation LIKE '%" . $d . "%'
                             OR c.titre LIKE '%" . $d . "%'
                             OR c.description LIKE '%" . $d . "%'
                             OR villes.code_postal LIKE '%" . $d . "%'   
                                 
                             OR villes.delegation LIKE '%" . $d . "%' )";

            $query = $em->createNativeQuery($query_search, $rsm);


            $covoiturages = $query->getResult();


            /*
              $em = $this->container->get('Doctrine')->getEntityManager();
              $Covo = $em->getRepository('GestionCovoiturageBundle:Covoiturages')->findById($covoiturages[0]->getId());
              echo"******zabrommm id createur***********".$Covo->getIdCreateur(); */


            return $this->render('GestionCovoiturageBundle:Covoiturages:Recha.html.twig', array(
                        'entities' => $covoiturages));
        }

        return $this->render('GestionCovoiturageBundle:Covoiturages:Recha.html.twig', array(
                    'entities' => $covoiturages));
    }

    public function FindgouvernoratAction() {
        $em = $this->getDoctrine()->getManager();
        $Request = $this->getRequest();
        $ville = new Villes();
        if ('GET' == $Request->getMethod()) {
            $query = $em->createQuery(
                    'SELECT DISTINCT v.gouvernorat
                         FROM FrontMNRSBundle:Villes v  ');
            $ville = $query->getResult();
            return $ville;
        }

        return $ville;
    }

    public function showAction($id) {

        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('GestionCovoiturageBundle:Covoiturages')->find($id);

        return $this->render('GestionCovoiturageBundle:Covoiturages:show.html.twig', array(
                    'entity' => $entity
        ));
    }

    public function deleteAction($id) {

        $em = $this->getDoctrine()->getManager();

        $c = $em->getRepository('FrontMNRSBundle:Covoiturages')->findOneById($id);
        $e = $em->getRepository('RayzerCoderUserBundle:User')->findOneById($c->getIdCreateur());
        $req2 = $em->createQuery("select u from FrontMNRSBundle:Participants u where u.idCovoiturage=:c")
                ->setParameter('c', $c->getId());

        $p = $req2->getResult();

        $Notification = new Notifications();
        $contenu = $e->getNom() . " " . $e->getPrenom() . " a annulé le covoiturage";
        $Notification->setContenu($contenu);
        $Notification->setIdExpediteur($e);
        $Notification->setDateCreation(new \Datetime());
        $Notification->setType(5);
        $Notification->setLu(0);


        if ($p) {
            for ($index = 0; $index < count($p); $index++) {
                $Notification->setIdDestinataire($p[$index]->getIdParticipant());
                $em->persist($Notification);
                $em->flush();
            }
        }


        $entity = $em->getRepository('FrontMNRSBundle:Participants')->findByidCovoiturage($id);
        if ($entity) {
            for ($index = 0; $index < count($entity); $index++) {
                $em->remove($entity[$index]);
                $em->flush();
            }
        }

        $entity = $em->getRepository('FrontMNRSBundle:Reservations')->findByidCovoiturage($id);

        if ($entity) {
            for ($index = 0; $index < count($entity); $index++) {
                $em->remove($entity[$index]);
                $em->flush();
            }
        }

        $entity = $em->getRepository('FrontMNRSBundle:Detours')->findByidCovoiturage($id);

        if ($entity) {
            for ($index = 0; $index < count($entity); $index++) {
                $em->remove($entity[$index]);
                $em->flush();
            }
        }

        $entity = $em->getRepository('FrontMNRSBundle:Covoiturages')->findOneById($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Covoiturages entity.');
        }

        $em->remove($entity);
        $em->flush();


        return $this->redirect($this->generateUrl('Mes_covoiturages'));
    }

    public function updateCovoiturageAction($id) {

        $em = $this->container->get('Doctrine')->getEntityManager();


        $idConnecte = $this->getUser()->getId();
        $c = $em->getRepository('FrontMNRSBundle:Covoiturages')->findOneById($id);
        $e = $em->getRepository('RayzerCoderUserBundle:User')->findOneById($c->getIdCreateur());
        $req2 = $em->createQuery("select u from FrontMNRSBundle:Participants u where u.idCovoiturage=:c")
                ->setParameter('c', $c->getId());

        $p = $req2->getResult();

        $Notification = new Notifications();
        $contenu = $e->getNom() . " " . $e->getPrenom() . " a modifié son covoiturage";
        $Notification->setContenu($contenu);
        $Notification->setIdExpediteur($e);
        $Notification->setDateCreation(new \Datetime());
        $Notification->setType(6);
        $Notification->setLu(0);


        if ($p) {
            for ($index = 0; $index < count($p); $index++) {
                $Notification->setIdDestinataire($p[$index]->getIdParticipant());
                $em->persist($Notification);
                $em->flush();
            }
        }


        $entity = $em->getRepository('FrontMNRSBundle:Participants')->findByidCovoiturage($id);
        if ($entity) {
            for ($index = 0; $index < count($entity); $index++) {
                $em->remove($entity[$index]);
                $em->flush();
            }
        }


        $Covoiturage = $em->getRepository('FrontMNRSBundle:Covoiturages')->findOneById($id);

        $form = $this->container->get('form.factory')->create(new CovoituragesType(), $Covoiturage);

        $request = $this->getRequest();


        if ($request->getMethod() == "POST") {

            $form->bind($request);
            if ($form->isValid()) {
                $Covoiturage->setDateMiseajour(new \Datetime());
                $em->persist($Covoiturage);
                $em->flush();
                return $this->redirect($this->generateUrl('Mes_covoiturages'));
            }
        }

        $query = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idConnecte);
        $queryy = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idConnecte);
        $notifications = $queryy->getResult();
        $messages = $query->getResult();

        return $this->render('GestionCovoiturageBundle:Covoiturages:edit.html.twig', array(
                    'form' => $form->createView(),
                    'notifications' => $notifications,
                    'messages' => $messages,
        ));
    }

}

