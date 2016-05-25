<?php

namespace RayzerCoder\UserBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use RayzerCoder\UserBundle\Form\Type\UserRechercheFormType;
use RayzerCoder\UserBundle\Form\Type\SimpleRechercheFormType;
use RayzerCoder\UserBundle\Form\IdentityPictureType;
use RayzerCoder\UserBundle\Form\Type\EvaluerFormType;
use Front\MNRSBundle\Entity\Evaluations;

class DefaultController extends Controller {

    public function indexAction() {
        return $this->render('RayzerCoderUserBundle:Default:index.html.twig', array());
    }

    public function showAction() {
        $user = $this->container->get('security.context')->getToken()->getUser();
        if (!is_object($user) || !$user instanceof UserInterface) {
            throw new AccessDeniedException('This user does not have access to this section.');
        }
        return $this->container->get('templating')->renderResponse('RayzerCoderUserBundle:Default:show.html.' . $this->container->getParameter('fos_user.template.engine'), array('user' => $user));
    }

    public function showUserAction($id) {

        $requete = $this->get('request');

        if (($requete->getMethod() == 'POST')) {
            $formshow = 0;
            $em = $this->getDoctrine()->getManager();
            $user = $em->getRepository('RayzerCoderUserBundle:User')->find($id);
            $note = $user->getNote() + $_POST['rating'];
            $user->setNote($note);
            $qb = $em->createQueryBuilder();
            $q = $qb->update('RayzerCoderUserBundle:User', 'u')
                    ->set('u.note', '?1')
                    ->where('u.id = ?2')
                    ->setParameter(1, $note)
                    ->setParameter(2, $id)
                    ->getQuery();
            $p = $q->execute();

            $evaluation = new Evaluations();

            $covoiturage = $em->getRepository('FrontMNRSBundle:Covoiturages')->find(1);
            $evaluation->setNote($_POST['rating']);
            $evaluation->setMessage($_POST['rating']);
            $evaluation->setIdEvaluateur($this->getUser());
            $evaluation->setIdCovoiturage($covoiturage);

            $em->persist($evaluation);
            $em->flush();







//            $queryBuilder = $em->createQueryBuilder();
//    $queryBuilder
//        ->update('RayzerCoder\UserBundle\Entity\User', 'u')
//        ->set('u.rating', 5)
//        ->where($queryBuilder->expr()->eq('u.id', $id));
//    $p = $queryBuilder->execute();  
//            $request = $this->getRequest();
//            $rating = $this->getRequest()->query->get('rating');
//            $commentaire = $request->query->get('commentaire');



            return $this->render('RayzerCoderUserBundle:Default:show.html.twig', array('user' => $user, 'formshow' => $formshow));
        } else {

            $formshow = 1;
            $em = $this->getDoctrine()->getManager();
            $user = $em->getRepository('RayzerCoderUserBundle:User')->find($id);
            $form = $this->createForm(new EvaluerFormType());
            if ($user == null) {
                $user = $this->container->get('security.context')->getToken()->getUser();
                if (!is_object($user) || !$user instanceof UserInterface) {
                    throw new AccessDeniedException('This user does not have access to this section.');
                }
            }

            return $this->render('RayzerCoderUserBundle:Default:show.html.twig', array('user' => $user, 'formshow' => $formshow));
        }
    }

    public function rechercheAction() {
        $form = $this->createForm(new UserRechercheFormType());
        $request = $this->getRequest();
        if ($request->getMethod() == 'POST') {
            $form->bind($request);

            //On vérifie que les valeurs entrées sont correctes
            if ($form->isValid()) {
                $em = $this->getDoctrine()->getManager();

                //On récupère les données entrées dans le formulaire par l'utilisateur
                $data = $this->getRequest()->request->get('rayzer_coder_userbundle_userrecherche');

                //On va récupérer la méthode dans le repository afin de trouver toutes les annonces filtrées par les paramètres du formulaire
                $liste_users = $em->getRepository('RayzerCoderUserBundle:User')->findUserByParametres($data);

                //Puis on redirige vers la page de visualisation de cette liste d'annonces
                return $this->render('RayzerCoderUserBundle:Default:resultatRecherche.html.twig', array('liste_users' => $liste_users));
            }
        }

        // À ce stade :
        // - Soit la requête est de type GET, donc le visiteur vient d'arriver sur la page et veut voir le formulaire
        // - Soit la requête est de type POST, mais le formulaire n'est pas valide, donc on l'affiche de nouveau
        return $this->render('RayzerCoderUserBundle:Default:rechercheUser.html.twig', array('form' => $form->createView()));
    }

    public function simpleRechercheAction() {
        $form = $this->createForm(new SimpleRechercheFormType());
        $request = $this->getRequest();
        if ($request->getMethod() == 'POST') {
            $form->bind($request);

            //On vérifie que les valeurs entrées sont correctes
            if ($form->isValid()) {
                $em = $this->getDoctrine()->getManager();

                //On récupère les données entrées dans le formulaire par l'utilisateur
                $data = $this->getRequest()->request->get('rayzer_coder_userbundle_simplerecherche');

                //On va récupérer la méthode dans le repository afin de trouver toutes les annonces filtrées par les paramètres du formulaire
                $liste_users = $em->getRepository('RayzerCoderUserBundle:User')->findUserByParametre($data);

                //Puis on redirige vers la page de visualisation de cette liste d'annonces
                return $this->render('RayzerCoderUserBundle:Default:resultatRecherche.html.twig', array('liste_users' => $liste_users));
            }
        }

        // À ce stade :
        // - Soit la requête est de type GET, donc le visiteur vient d'arriver sur la page et veut voir le formulaire
        // - Soit la requête est de type POST, mais le formulaire n'est pas valide, donc on l'affiche de nouveau
        return $this->render('RayzerCoderUserBundle:Default:rechercheUser.html.twig', array('form' => $form->createView()));
    }

    public function editAvatarAction() {
        $usr = $this->getUser();

        $form = $this->createForm(new IdentityPictureType(), $usr);

        if ($this->getRequest()->getMethod() === 'POST') {
            $form->bind($this->getRequest());
            if ($form->isValid()) {
                $em = $this->getDoctrine()->getEntityManager();

                $usr->uploadProfilePicture();

                $em->persist($usr);
                $em->flush();

                $this->redirect($this->generateUrl('fos_user_profile_show'));
            }
        }

        return $this->render('RayzerCoderUserBundle:Default:editAvatar.html.twig', array(
                    'user' => $usr,
                    'form' => $form->createView()
                        )
        );
    }

}
