<?php

namespace Gestion\CovoiturageBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of ReservationsController
 *
 * @author Hhussein
 */
class ReservationsController extends Controller {

    public function ListReservationsAction() {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('FrontMNRSBundle:Reservations')->findAll();

        return $this->render('GestionCovoiturageBundle:Reservations:index.html.twig', array(
                    'entities' => $entities,
        ));
    }

    public function AjoutReservationAction($id, $idd) {
        // id covoiturage idd covoitureur createur
        $em = $this->getDoctrine()->getManager();
        $idcovoitureurConnecte = $this->get('security.context')->getToken()->getUser()->getId();
        $CovoitureurConnecte = $em->getRepository('RayzerCoderUserBundle:User')->findOneById($idcovoitureurConnecte);
        $id = $em->getRepository('FrontMNRSBundle:Covoiturages')->findOneById($id);
        $idd = $em->getRepository('RayzerCoderUserBundle:User')->findOneById($idd);
        $Reservation = new \Front\MNRSBundle\Entity\Reservations;
        $Reservation->setIdCovoiturage($id);
        $Reservation->setIdCovoitureur($idd);
        $Reservation->setDateReservation(new \Datetime());
        $Reservation->setEtat(0);
        $em->persist($Reservation); // INSERT fil cache 
        $em->flush(); // commit       validation de insertion  

        $c = $em->getRepository('FrontMNRSBundle:Covoiturages')->findOneById($id);
        $e = $em->getRepository('RayzerCoderUserBundle:User')->findOneById($c->getIdCreateur());

        $Notification = new \Front\MNRSBundle\Entity\Notifications();
        $contenu = $idd->getNom() . " " . $idd->getPrenom() . " demande de reserver une place dans votre covoiturage";
        $Notification->setContenu($contenu);
        $Notification->setIdExpediteur($idd);
        $Notification->setDateCreation(new \Datetime());
        $Notification->setType(4);
        $Notification->setLu(0);
        $Notification->setIdDestinataire($CovoitureurConnecte);

        $em->persist($Notification);
        $em->flush();

        return $this->redirect($this->generateUrl('covoiturage_accueil')); // rederection ficher routing
    }

    public function deleteAction(Request $request, $id) {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('FrontMNRSBundle:Covoiturages')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find Covoiturages entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('covoiturages'));
    }

    public function deletereservationAction($id) {

        $em = $this->getDoctrine()->getManager();
        $entity = $em->getRepository('FrontMNRSBundle:Reservations')->findByidCovoiturage($id);

        if ($entity) {
            for ($index = 0; $index < count($entity); $index++) {
                $em->remove($entity[$index]);
                $em->flush();
            }
        }

        return $this->redirect($this->generateUrl('Mes_covoiturages'));
        //  return $this->redirect($this->generateUrl('covoiturages_delete'));
    }

}

?>
