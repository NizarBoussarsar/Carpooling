<?php

namespace Gestion\CovoiturageBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Template;
use Gestion\CovoiturageBundle\Entity\Notifications;
use Gestion\CovoiturageBundle\Form\NotificationsType;

/**
 * Notifications controller.
 *
 * @Route("/notifications")
 */
class NotificationsController extends Controller {

    /**
     * Lists all Notifications entities.
     *
     * @Route("/", name="notifications")
     * @Method("GET")
     * @Template()
     */
    public function indexAction() {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('FrontMNRSBundle:Notifications:FrontMNRSBundle:Reservations:index.html.twig')->findAll();

        return array(
            'entities' => $entities,
        );
    }

    /**
     * Creates a new Notifications entity.
     *
     * @Route("/", name="notifications_create")
     * @Method("POST")
     * @Template("GestionCovoiturageBundle:Notifications:new.html.twig")
     */
    public function createAction(Request $request) {
        $entity = new Notifications();
        $form = $this->createCreateForm($entity);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($entity);
            $em->flush();

            return $this->redirect($this->generateUrl('notifications_show', array('id' => $entity->getId())));
        }

        return array(
            'entity' => $entity,
            'form' => $form->createView(),
        );
    }

    /**
     * Creates a form to create a Notifications entity.
     *
     * @param Notifications $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createCreateForm(Notifications $entity) {
        $form = $this->createForm(new NotificationsType(), $entity, array(
            'action' => $this->generateUrl('notifications_create'),
            'method' => 'POST',
        ));

        $form->add('submit', 'submit', array('label' => 'Create'));

        return $form;
    }

    /**
     * Displays a form to create a new Notifications entity.
     *
     * @Route("/new", name="notifications_new")
     * @Method("GET")
     * @Template()
     */
    public function newAction() {
        $entity = new Notifications();
        $form = $this->createCreateForm($entity);

        return array(
            'entity' => $entity,
            'form' => $form->createView(),
        );
    }

    /**
     * Finds and displays a Notifications entity.
     *
     * @Route("/{id}", name="notifications_show")
     * @Method("GET")
     * @Template()
     */
    public function showAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('GestionCovoiturageBundle:Notifications')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Notifications entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return array(
            'entity' => $entity,
            'delete_form' => $deleteForm->createView(),
        );
    }

    /**
     * Displays a form to edit an existing Notifications entity.
     *
     * @Route("/{id}/edit", name="notifications_edit")
     * @Method("GET")
     * @Template()
     */
    public function editAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('GestionCovoiturageBundle:Notifications')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Notifications entity.');
        }

        $editForm = $this->createEditForm($entity);
        $deleteForm = $this->createDeleteForm($id);

        return array(
            'entity' => $entity,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        );
    }

    /**
     * Creates a form to edit a Notifications entity.
     *
     * @param Notifications $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createEditForm(Notifications $entity) {
        $form = $this->createForm(new NotificationsType(), $entity, array(
            'action' => $this->generateUrl('notifications_update', array('id' => $entity->getId())),
            'method' => 'PUT',
        ));

        $form->add('submit', 'submit', array('label' => 'Update'));

        return $form;
    }

    /**
     * Edits an existing Notifications entity.
     *
     * @Route("/{id}", name="notifications_update")
     * @Method("PUT")
     * @Template("GestionCovoiturageBundle:Notifications:edit.html.twig")
     */
    public function updateAction(Request $request, $id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('GestionCovoiturageBundle:Notifications')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Notifications entity.');
        }

        $deleteForm = $this->createDeleteForm($id);
        $editForm = $this->createEditForm($entity);
        $editForm->handleRequest($request);

        if ($editForm->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('notifications_edit', array('id' => $id)));
        }

        return array(
            'entity' => $entity,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        );
    }

    /**
     * Deletes a Notifications entity.
     *
     * @Route("/{id}", name="notifications_delete")
     * @Method("DELETE")
     */
    public function deleteAction(Request $request, $id) {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('GestionCovoiturageBundle:Notifications')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find Notifications entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('notifications'));
    }

    /**
     * Creates a form to delete a Notifications entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm($id) {
        return $this->createFormBuilder()
                        ->setAction($this->generateUrl('notifications_delete', array('id' => $id)))
                        ->setMethod('DELETE')
                        ->add('submit', 'submit', array('label' => 'Delete'))
                        ->getForm()
        ;
    }

    public function testAction($c) {
        $em = $this->getDoctrine()->getManager();
        $req2 = $em->createQuery("select u from GestionCovoiturageBundle:Participants u where u.idCovoiturage=:c")
                ->setParameter('c', $c);
        $p = $req2->getResult();
        return $this->render('GestionCovoiturageBundle:Default:test.html.twig', array('p' => $p));
    }

    public function AjoutNotificationAction($e, $d, $c, $t) {
        $em = $this->getDoctrine()->getManager();

         
        $e = $em->getRepository('GestionCovoiturageBundle:Covoitureurs')->findOneById($e);
        $d = $em->getRepository('GestionCovoiturageBundle:Covoitureurs')->findOneById($d);
        $x = $em->getRepository('GestionCovoiturageBundle:Covoitureurs')->find($e);

        $req = $em->createQuery("select u from GestionCovoiturageBundle:Reservations u where u.idCovoitureur = :e AND u.idCovoiturage=:c")->setParameter('e', $e)
                ->setParameter('c', $c);
        $r = $req->getResult();
        
        if (count($r)!=0){
        $c = $em->getRepository('GestionCovoiturageBundle:Covoiturages')->findOneById($r[0]->getIdCovoiturage());
        $vd = $em->getRepository('GestionCovoiturageBundle:Villes')->findOneById($c->getIdVilleDepart());
        $va = $em->getRepository('GestionCovoiturageBundle:Villes')->findOneById($c->getIdVilleArrivee());
            }
        /*         * ********************************* */
        $req2 = $em->createQuery("select u from GestionCovoiturageBundle:Participants u where u.idCovoiturage=:c")
                ->setParameter('c', $c);
        $p = $req2->getResult();
        /*         * ********************************* */

        $Notification = new Notifications();
        $Notification->setIdExpediteur($e);
        $Notification->setIdDestinataire($d);
        $Notification->setDateCreation(new \Datetime());
        $Notification->setType($t);
        $Notification->setLu(0);

// modification covoiturage supp // refuser  la demande de reservation
        switch ($t) {
            case 1:
                $contenu = "Vous etes accepté dans le covoiturage qui part " . $vd->getDelegation() . " et arrive a " . $va->getDelegation() . " le " . $c->getDateDepart()->format('Y-m-d H:i:s');
                break;
            case 2:
                $contenu = "Vous n'etes pas accepté dans le covoiturage qui part " . $vd->getDelegation() . " et arrive a " . $va->getDelegation() . " le " . $c->getDateDepart()->format('Y-m-d H:i:s');
                break;
            case 3:
                $contenu = "Bonjour, j'ai annulé ma réservation";
                break;
            case 4:
                $contenu = $x->getNom() . " " . $x->getPrenom() . " demande de reserver une place dans votre covoiturage";
                break;
            case 5:
                $contenu = $x->getNom() . " " . $x->getPrenom() . " a annulé le covoiturage";
                break;
            case 6:
                $contenu = $x->getNom() . " " . $x->getPrenom() . " a modifié le covoiturage";
                break;
        }
        $Notification->setContenu($contenu);
        $em->persist($Notification); // INSERT fil cache 
        $em->flush(); // commit       validation de insertion  

        $notification = new Notifications();
        return $notification;
        //return $this->redirect($this->generateUrl('notifications')); // rederection ficher routing
        // return $this->render('GestionCovoiturageBundle:Default:test.html.twig', array('p' => $p));
    }

}
