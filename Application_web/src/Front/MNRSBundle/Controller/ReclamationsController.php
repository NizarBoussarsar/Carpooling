<?php

namespace Front\MNRSBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Template;
use Front\MNRSBundle\Entity\Reclamations;
use Front\MNRSBundle\Form\ReclamationsType;

/**
 * Reclamations controller.
 *
 * @Route("/reclamations")
 */
class ReclamationsController extends Controller {

    /**
     * Lists all Reclamations entities.
     *
     * @Route("/", name="reclamations")
     * @Method("GET")
     * @Template()
     */
    public function indexAction() {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('FrontMNRSBundle:Reclamations')->findAll();

        return array(
            'entities' => $entities,
        );
    }

    /**
     * Creates a new Reclamations entity.
     *
     * @Route("/", name="reclamations_create")
     * @Method("POST")
     * @Template("FrontMNRSBundle:Reclamations:new.html.twig")
     */
    public function createAction(Request $request) {
        $entity = new Reclamations();
        $entity->setVu(0);
        $form = $this->createCreateForm($entity);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($entity);
            $em->flush();

            return $this->redirect($this->generateUrl('reclamations_create'));
        }

        return array(
            'entity' => $entity,
            'form' => $form->createView(),
        );
    }

    /**
     * Creates a form to create a Reclamations entity.
     *
     * @param Reclamations $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createCreateForm(Reclamations $entity) {
        $form = $this->createForm(new ReclamationsType(), $entity, array(
            'action' => $this->generateUrl('reclamations_create'),
            'method' => 'POST',
        ));

        $form->add('submit', 'submit', array('label' => 'Envoyer'));

        return $form;
    }

    /**
     * Displays a form to create a new Reclamations entity.
     *
     * @Route("/new", name="reclamations_new")
     * @Method("GET")
     * @Template()
     */
    public function newAction() {
        $entity = new Reclamations();
        $form = $this->createCreateForm($entity);

        return array(
            'entity' => $entity,
            'form' => $form->createView(),
        );
    }

    /**
     * Finds and displays a Reclamations entity.
     *
     * @Route("/{id}", name="reclamations_show")
     * @Method("GET")
     * @Template()
     */
    public function showAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('FrontMNRSBundle:Reclamations')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Reclamations entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return array(
            'entity' => $entity,
            'delete_form' => $deleteForm->createView(),
        );
    }

    /**
     * Displays a form to edit an existing Reclamations entity.
     *
     * @Route("/{id}/edit", name="reclamations_edit")
     * @Method("GET")
     * @Template()
     */
    public function editAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('FrontMNRSBundle:Reclamations')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Reclamations entity.');
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
     * Creates a form to edit a Reclamations entity.
     *
     * @param Reclamations $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createEditForm(Reclamations $entity) {
        $form = $this->createForm(new ReclamationsType(), $entity, array(
            'action' => $this->generateUrl('reclamations_update', array('id' => $entity->getId())),
            'method' => 'PUT',
        ));

        $form->add('submit', 'submit', array('label' => 'Update'));

        return $form;
    }

    /**
     * Edits an existing Reclamations entity.
     *
     * @Route("/{id}", name="reclamations_update")
     * @Method("PUT")
     * @Template("FrontMNRSBundle:Reclamations:edit.html.twig")
     */
    public function updateAction(Request $request, $id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('FrontMNRSBundle:Reclamations')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Reclamations entity.');
        }

        $deleteForm = $this->createDeleteForm($id);
        $editForm = $this->createEditForm($entity);
        $editForm->handleRequest($request);

        if ($editForm->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('reclamations_edit', array('id' => $id)));
        }

        return array(
            'entity' => $entity,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        );
    }

    /**
     * Deletes a Reclamations entity.
     *
     * @Route("/{id}", name="reclamations_delete")
     * @Method("DELETE")
     */
    public function deleteAction(Request $request, $id) {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('FrontMNRSBundle:Reclamations')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find Reclamations entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('reclamations'));
    }

    /**
     * Creates a form to delete a Reclamations entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm($id) {
        return $this->createFormBuilder()
                        ->setAction($this->generateUrl('reclamations_delete', array('id' => $id)))
                        ->setMethod('DELETE')
                        ->add('submit', 'submit', array('label' => 'Delete'))
                        ->getForm()
        ;
    }

}
