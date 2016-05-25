<?php

namespace Front\MNRSBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller {

    //TO GET THE CONNECTED USER
    //$user->$this->get('security.context')->getToken()->getUser();

    public function indexAction() {
        $em = $this->getDoctrine()->getManager();
        $query = $em->createQuery('SELECT c FROM FrontMNRSBundle:Covoiturages c WHERE c.dateDepart > CURRENT_DATE()')->setMaxResults(20);
        //$query = $em->createQuery('SELECT c FROM FrontMNRSBundle:Covoiturages c WHERE c.dateDepart > :date_depart')->setParameter('date_depart', new \Date());
        $covoiturages = $query->getResult();
        return $this->render('FrontMNRSBundle:Default:index.html.twig', array('covoiturages' => $covoiturages));
    }

    public function plusCovoituragesAction() {
        $em = $this->getDoctrine()->getManager();
        $query = $em->createQuery('SELECT c FROM FrontMNRSBundle:Covoiturages c WHERE c.dateDepart > CURRENT_DATE()');
        $covoiturages = $query->getResult();
        return $this->render('FrontMNRSBundle:Default:plusCovoiturages.html.twig', array('covoiturages' => $covoiturages));
    }

    public function laCharteAction() {
        return $this->render('FrontMNRSBundle:Default:LaCharte.html.twig', array());
    }

    public function faqAction() {
        return $this->render('FrontMNRSBundle:Default:FAQ.html.twig', array());
    }

    public function showRecievedAction() {
        $idConnecte = $this->getUser()->getId();
        $em = $this->getDoctrine()->getManager();
        $query = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idConnecte);
        $queryy = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idConnecte);
        $notifications = $queryy->getResult();
        $messages = $query->getResult();
        return $this->render('FrontMNRSBundle:Default:mesMessages.html.twig', array('messages' => $messages, 'notifications' => $notifications));
    }

    public function showAllAction() {
        $idConnecte = $this->getUser()->getId();
        $em = $this->getDoctrine()->getManager();
        $query1 = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idConnecte);
        $query = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idConnecte);
        $queryy = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idConnecte);
        $notifications = $queryy->getResult();
        $messages = $query1->getResult();
        $nbmsg = $query->getResult();
        return $this->render('FrontMNRSBundle:Default:toutMesMessages.html.twig', array('messages' => $messages, 'notifications' => $notifications, 'nbmsgs' => $nbmsg));
    }

    public function showSentAction() {
        $idConnecte = $this->getUser()->getId();
        $em = $this->getDoctrine()->getManager();
        $query = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idExpediteur = :idExpediteur ORDER BY m.dateEnvoie DESC')->setParameter('idExpediteur', $idConnecte);
        $sent_messages = $query->getResult();

        $query1 = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idConnecte);
        $query2 = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idConnecte);

        $notifications = $query2->getResult();
        $messages = $query1->getResult();

        return $this->render('FrontMNRSBundle:Default:messagesSent.html.twig', array('entities' => $sent_messages, 'messages' => $messages, 'notifications' => $notifications));
    }

    public function showNotificationsAction() {
        $idConnecte = $this->getUser()->getId();

        $em = $this->getDoctrine()->getManager();
        $query = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idConnecte);
        $notifications = $query->getResult();

        $query1 = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idConnecte);
        $query2 = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idConnecte);

        $not = $query2->getResult();
        $messages = $query1->getResult();
        return $this->render('FrontMNRSBundle:Default:notificationsRecus.html.twig', array('notifications' => $notifications, 'messages' => $messages, 'noti' => $not));
    }

    public function showReclamationsAction() {
        $em = $this->getDoctrine()->getManager();
        $query = $em->createQuery('SELECT r FROM FrontMNRSBundle:Reclamations r WHERE r.vu = 0');
        $reclamations = $query->getResult();
        return $this->render('FrontMNRSBundle:Default:reclamationsRecus.html.twig', array('reclamations' => $reclamations));
    }

}
