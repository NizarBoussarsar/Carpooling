<?php

namespace Front\MNRSBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Template;
use Front\MNRSBundle\Entity\Statistiques;
use Front\MNRSBundle\Form\StatistiquesType;

/**
 * Statistiques controller.
 *
 * @Route("/statistiques")
 */
class StatistiquesController extends Controller {

    /**
     * Lists all Statistiques entities.
     *
     * @Route("/", name="statistiques")
     * @Method("GET")
     * @Template()
     */
    public function freqVilleAction() {
        $idCovoitureurConnecte = $this->getUser()->getId();

        $em = $this->getDoctrine()->getManager();

        $query1 = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);
        $query2 = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);

        $notifications = $query2->getResult();
        $messages = $query1->getResult();

        $query = $em->createQuery("SELECT COUNT( p ) as nombre, v1.gouvernorat AS depart, v2.gouvernorat AS arrivee FROM FrontMNRSBundle:participants AS p , FrontMNRSBundle:covoiturages AS c  ,FrontMNRSBundle:villes AS v1 ,FrontMNRSBundle:villes AS v2 
                where c.id = p.idCovoiturage and v1.id = c.idVilleDepart and v2.id = c.idVilleArrivee and p.idParticipant=:idp
               group by depart")->setParameter('idp', $idCovoitureurConnecte);

        $entities = $query->getResult();

        return array(
            'entities' => $entities,
            'messages' => $messages, 
            'notifications' => $notifications
        );
    }

    public function coutParMoisAction() {
        $idCovoitureurConnecte = $this->getUser()->getId();
        $em = $this->getDoctrine()->getManager();
        $query = $em->createQuery("SELECT sum( c.prix ) as somme ,p.dateParticipation as datee, SUBSTRING(p.dateParticipation, 1, 8) as month FROM FrontMNRSBundle:participants AS p , FrontMNRSBundle:covoiturages AS c 
                where c.id = p.idCovoiturage    and p.idParticipant=:idp
               group by month")->setParameter('idp', $idCovoitureurConnecte);

        $entities = $query->getResult();
        $query1 = $em->createQuery("Select c.date_enregistrement as date_en from RayzerCoderUserBundle:User c where 
             c.id=:idp")->setParameter('idp', $idCovoitureurConnecte);

        $entities1 = $query1->getResult();
        
        $query11 = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);
        $query2 = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);

        $notifications = $query2->getResult();
        $messages = $query11->getResult();
        return $this->render('FrontMNRSBundle:Statistiques:coutParMois.html.twig', array('entities' => $entities, 'entities1' => $entities1, 'messages' => $messages, 'notifications' => $notifications));
    }

    public function EvalAction() {
        $idCovoitureurConnecte = $this->getUser()->getId();
        $em = $this->getDoctrine()->getManager();
//        $repository = $this->getDoctrine()
//                ->getRepository('RayzerCoderUserBundle:User');
        $query = $em->createQuery("SELECT max (c.note) as maxNote from RayzerCoderUserBundle:User as c");
        $entities = $query->getResult();
        
        $query1 = $em->createQuery("select c.note from RayzerCoderUserBundle:User as c where c.id=:idp")->setParameter('idp', $idCovoitureurConnecte);

        $entities1 = $query1->getResult();
        $query11 = $em->createQuery('SELECT m FROM FrontMNRSBundle:Messages m WHERE m.idDestinataire = :idDestinataire AND m.lu = 0 ORDER BY m.dateEnvoie DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);
        $query2 = $em->createQuery('SELECT n FROM FrontMNRSBundle:Notifications n WHERE n.lu = 0 AND n.idDestinataire = :idDestinataire ORDER BY n.dateCreation DESC')->setParameter('idDestinataire', $idCovoitureurConnecte);

        $notifications = $query2->getResult();
        $messages = $query11->getResult();
        return $this->render('FrontMNRSBundle:Statistiques:Eval.html.twig', array('entities' => $entities, 'entities1' => $entities1, 'messages' => $messages, 'notifications' => $notifications));
    }

    /**
     * Creates a new Statistiques entity.
     *
     * @Route("/", name="statistiques_create")
     * @Method("POST")
     * @Template("FrontMNRSBundle:Statistiques:new.html.twig")
     */
    public function createAction(Request $request) {
        $entity = new Statistiques();
        $form = $this->createCreateForm($entity);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($entity);
            $em->flush();

            return $this->redirect($this->generateUrl('statistiques_show', array('id' => $entity->getId())));
        }

        return array(
            'entity' => $entity,
            'form' => $form->createView(),
        );
    }

    /**
     * Creates a form to create a Statistiques entity.
     *
     * @param Statistiques $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createCreateForm(Statistiques $entity) {
        $form = $this->createForm(new StatistiquesType(), $entity, array(
            'action' => $this->generateUrl('statistiques_create'),
            'method' => 'POST',
        ));

        $form->add('submit', 'submit', array('label' => 'Create'));

        return $form;
    }

    /**
     * Displays a form to create a new Statistiques entity.
     *
     * @Route("/new", name="statistiques_new")
     * @Method("GET")
     * @Template()
     */
    public function newAction() {
        $entity = new Statistiques();
        $form = $this->createCreateForm($entity);

        return array(
            'entity' => $entity,
            'form' => $form->createView(),
        );
    }

    /**
     * Finds and displays a Statistiques entity.
     *
     * @Route("/{id}", name="statistiques_show")
     * @Method("GET")
     * @Template()
     */
    public function showAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('FrontMNRSBundle:Statistiques')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Statistiques entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return array(
            'entity' => $entity,
            'delete_form' => $deleteForm->createView(),
        );
    }

    /**
     * Displays a form to edit an existing Statistiques entity.
     *
     * @Route("/{id}/edit", name="statistiques_edit")
     * @Method("GET")
     * @Template()
     */
    public function editAction($id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('FrontMNRSBundle:Statistiques')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Statistiques entity.');
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
     * Creates a form to edit a Statistiques entity.
     *
     * @param Statistiques $entity The entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createEditForm(Statistiques $entity) {
        $form = $this->createForm(new StatistiquesType(), $entity, array(
            'action' => $this->generateUrl('statistiques_update', array('id' => $entity->getId())),
            'method' => 'PUT',
        ));

        $form->add('submit', 'submit', array('label' => 'Update'));

        return $form;
    }

    /**
     * Edits an existing Statistiques entity.
     *
     * @Route("/{id}", name="statistiques_update")
     * @Method("PUT")
     * @Template("FrontMNRSBundle:Statistiques:edit.html.twig")
     */
    public function updateAction(Request $request, $id) {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('FrontMNRSBundle:Statistiques')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Statistiques entity.');
        }

        $deleteForm = $this->createDeleteForm($id);
        $editForm = $this->createEditForm($entity);
        $editForm->handleRequest($request);

        if ($editForm->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('statistiques_edit', array('id' => $id)));
        }

        return array(
            'entity' => $entity,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        );
    }

    /**
     * Deletes a Statistiques entity.
     *
     * @Route("/{id}", name="statistiques_delete")
     * @Method("DELETE")
     */
    public function deleteAction(Request $request, $id) {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('FrontMNRSBundle:Statistiques')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find Statistiques entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('statistiques'));
    }

    /**
     * Creates a form to delete a Statistiques entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm($id) {
        return $this->createFormBuilder()
                        ->setAction($this->generateUrl('statistiques_delete', array('id' => $id)))
                        ->setMethod('DELETE')
                        ->add('submit', 'submit', array('label' => 'Delete'))
                        ->getForm()
        ;
    }

}
