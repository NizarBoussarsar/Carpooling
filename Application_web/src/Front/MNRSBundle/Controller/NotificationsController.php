<?php

namespace Front\MNRSBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Template;
use Front\MNRSBundle\Entity\Notifications;
use Front\MNRSBundle\Form\NotificationsType;

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
        $idCovoitureurConnecte = $this->getUser()->getId();

        $em = $this->getDoctrine()->getManager();

        $query1 = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);
        $query2 = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);

        $notifications = $query2->getResult();
        $messages = $query1->getResult();

        $entities = $em->getRepository('FrontMNRSBundle:Notifications')->findBy(array('idDestinataire' => $idCovoitureurConnecte));

        return array(
            'entities' => $entities,
            'messages' => $messages,
            'notifications' => $notifications
        );
    }

    /**
     * Creates a new Notifications entity.
     *
     * @Route("/", name="notifications_create")
     * @Method("POST")
     * @Template("FrontMNRSBundle:Notifications:new.html.twig")
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
        $idCovoitureurConnecte = $this->getUser()->getId();


        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('FrontMNRSBundle:Notifications')->find($id);

        $query1 = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);
        $query2 = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);

        $notifications = $query2->getResult();
        $messages = $query1->getResult();

        $entity->setLu(1);
        $em->flush();

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Notifications entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return array(
            'entity' => $entity,
            'delete_form' => $deleteForm->createView(),
            'messages' => $messages,
            'notifications' => $notifications
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

        $entity = $em->getRepository('FrontMNRSBundle:Notifications')->find($id);

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
     * @Template("FrontMNRSBundle:Notifications:edit.html.twig")
     */
    public function updateAction(Request $request, $id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('FrontMNRSBundle:Notifications')->find($id);

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
            $entity = $em->getRepository('FrontMNRSBundle:Notifications')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find Notifications entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('notifications_recus'));
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

}
