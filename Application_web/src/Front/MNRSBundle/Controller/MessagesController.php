<?php

namespace Front\MNRSBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Template;
use Front\MNRSBundle\Entity\Messages;
use Front\MNRSBundle\Form\MessagesType;

/**
 * Messages controller.
 *
 * @Route("/messages")
 */
class MessagesController extends Controller {

    /**
     * Lists all Messages entities.
     *
     * @Route("/", name="messages")
     * @Method("GET")
     * @Template()
     */
    public function indexAction() {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('FrontMNRSBundle:Messages')->findAll();

        return array(
            'entities' => $entities,
        );
    }

    /**
     * Creates a new Messages entity.
     *
     * @Route("/", name="messages_show_inbox")
     * @Method("POST")
     * @Template("FrontMNRSBundle:Messages:new.html.twig")
     */
    public function createAction(Request $request) {
        $entity = new Messages();
        $form = $this->createCreateForm($entity);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($entity);
            $em->flush();

            return $this->redirect($this->generateUrl('messages_show_inbox'));
        }

        return array(
            'entity' => $entity,
            'form' => $form->createView(),
        );
    }

    /**
     * Creates a form to create a Messages entity.
     *
     * @param Messages $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createCreateForm(Messages $entity) {
        $form = $this->createForm(new MessagesType(), $entity, array(
            'action' => $this->generateUrl('messages_create'),
            'method' => 'POST',
        ));

        $form->add('submit', 'submit', array('label' => 'Create'));

        return $form;
    }

    /**
     * Displays a form to create a new Messages entity.
     *
     * @Route("/new", name="messages_new")
     * @Method("GET")
     * @Template()
     */
    public function newAction() {
        $entity = new Messages();
        $form = $this->createCreateForm($entity);

        return array(
            'entity' => $entity,
            'form' => $form->createView(),
        );
    }

    /**
     * Finds and displays a Messages entity.
     *
     * @Route("/{id}", name="messages_show")
     * @Method("GET")
     * @Template()
     */
    public function showAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('FrontMNRSBundle:Messages')->find($id);
        $entity->setLu(1);

        $em->flush();
        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Messages entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        $message = new Messages;
        $idDestinataire = $entity->getIdExpediteur();
        $idCovoitureurConnecte = $this->getUser()->getId();
        $idExpediteur = $em->getRepository('RayzerCoderUserBundle:User')->findOneById($idCovoitureurConnecte);

        $query1 = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);
        $query2 = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);

        $notifications = $query2->getResult();
        $messages = $query1->getResult();


        $message->setIdExpediteur($idExpediteur);
        $message->setLu(0);
        $message->setDateEnvoie(new \Datetime());
        $message->setIdDestinataire($idDestinataire);
        $form = $this->createFormBuilder($message)
                ->add('contenu', 'textarea', array(
                    'attr' => array('cols' => '10', 'rows' => '10')))
                ->add('idDestinataire')
                ->add('objet', 'text', array(
                    'attr' => array('size' => '20')))
                ->add('send', 'submit')
                ->getForm();
        $request = $this->get('request');
        if ($request->getMethod() == 'POST') {
            $form->bind($request);
            if ($form->isValid()) {
                $em = $this->getDoctrine()->getManager();
                $em->persist($message);
                $em->flush();
                return $this->redirect($this->generateUrl('messages_show', array('id' => $message->getId())));
            }
        }
        return array(
            'entity' => $entity,
            'delete_form' => $deleteForm->createView(),
            'form' => $form->createView(),
            'messages' => $messages, 'notifications' => $notifications
        );
    }

    /**
     * Displays a form to edit an existing Messages entity.
     *
     * @Route("/{id}/edit", name="messages_edit")
     * @Method("GET")
     * @Template()
     */
    public function editAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('FrontMNRSBundle:Messages')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Messages entity.');
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
     * Creates a form to edit a Messages entity.
     *
     * @param Messages $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createEditForm(Messages $entity) {
        $form = $this->createForm(new MessagesType(), $entity, array(
            'action' => $this->generateUrl('messages_update', array('id' => $entity->getId())),
            'method' => 'PUT',
        ));

        $form->add('submit', 'submit', array('label' => 'Update'));

        return $form;
    }

    /**
     * Edits an existing Messages entity.
     *
     * @Route("/{id}", name="messages_update")
     * @Method("PUT")
     * @Template("FrontMNRSBundle:Messages:edit.html.twig")
     */
    public function updateAction(Request $request, $id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('FrontMNRSBundle:Messages')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Messages entity.');
        }

        $deleteForm = $this->createDeleteForm($id);
        $editForm = $this->createEditForm($entity);
        $editForm->handleRequest($request);

        if ($editForm->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('messages_edit', array('id' => $id)));
        }

        return array(
            'entity' => $entity,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        );
    }

    /**
     * Deletes a Messages entity.
     *
     * @Route("/{id}", name="messages_delete")
     * @Method("DELETE")
     */
    public function deleteAction(Request $request, $id) {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('FrontMNRSBundle:Messages')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find Messages entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('messages_show_inbox'));
    }

    /**
     * Creates a form to delete a Messages entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm($id) {
        return $this->createFormBuilder()
                        ->setAction($this->generateUrl('messages_delete', array('id' => $id)))
                        ->setMethod('DELETE')
                        ->add('submit', 'submit', array('label' => 'Supprimer'))
                        ->getForm()
        ;
    }

    /**
     * Creates a form to reply a Messages entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return \Symfony\Component\Form\Form The form
     */
//    private function createReplyForm($id) {
//        return $this->createFormBuilder()
//                        ->setAction($this->generateUrl('messages_reply', array('id' => $id)))
//                        ->setMethod('POST')
//                        ->add('submit', 'submit', array('label' => 'Répondre'))
//                        ->getForm();
//    }

    public function envoyerAction() {
        $message = new Messages;
        $idCovoitureurConnecte = $this->getUser()->getId();

        $em = $this->getDoctrine()->getManager();

        $query1 = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);
        $query2 = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);

        $notifications = $query2->getResult();
        $messages = $query1->getResult();

        $idExpediteur = $em->getRepository('RayzerCoderUserBundle:User')->findOneById($idCovoitureurConnecte);
        $message->setIdExpediteur($idExpediteur);
        $message->setLu(0);
        $message->setDateEnvoie(new \Datetime());
        $form = $this->createFormBuilder($message)
                ->add('contenu', 'textarea', array(
                    'attr' => array('cols' => '10', 'rows' => '10')))
                ->add('idDestinataire')
                ->add('objet', 'text', array(
                    'attr' => array('size' => '20')))
                ->add('Envoyer', 'submit')
                ->getForm();
        $request = $this->get('request');
        if ($request->getMethod() == 'POST') {
            $form->bind($request);
            if ($form->isValid()) {
                $em = $this->getDoctrine()->getManager();
                $em->persist($message);
                $em->flush();
                return $this->redirect($this->generateUrl('messages_show_inbox'));
            }
        }
        return $this->render('FrontMNRSBundle:Messages:new.html.twig', array(
                    'form' => $form->createView(), 'messages' => $messages, 'notifications' => $notifications));
    }

}
