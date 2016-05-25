<?php

namespace Gestion\CovoiturageBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Gestion\CovoiturageBundle\Entity\Detours;
use Gestion\CovoiturageBundle\Form\DetoursForm;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of DetoursController
 *
 * @author Hhussein
 */
class DetoursController extends Controller {

    public function ListDetoursAction() {

        $em = $this->container->get('Doctrine')->getEntityManager();
        $Detours = $em->getRepository('FrontMNRSBundle:Detours')->findAll();
        return $this->render('GestionCovoiturageBundle:Detours:index.html.twig', array(
                    'entities' => $Detours
        ));
    }

    public function AjoutDetoursAction() {

        $Detour = new Detours();
        $form = $this->container->get('form.factory')->create(new DetoursForm(), $Detour);

        $request = $this->getRequest();

        echo"avant a un poste";
        if ($request->getMethod() == "POST") {
            echo"suite a un poste";
            $form->bind($request); //recupereer les donnee au niveau formulaire 
            // if ($form->isValid()) {
            echo"suite a un poste";
            $em = $this->container->get('Doctrine')->getEntityManager();
            $em->persist($Detour); // INSERT fil cache 
            $em->flush(); // commit       validation de insertion    

            return $this->redirect($this->generateUrl('detours')); // rederection ficher routing
            //  }
        }


        return $this->render('GestionCovoiturageBundle:Detours:new.html.twig', array(
                    'form' => $form->createView()
        ));
    }

    
     public function deletedetoursAction($id) {

        $em = $this->getDoctrine()->getManager();
        $entity = $em->getRepository('FrontMNRSBundle:Detours')->findByidCovoiturage($id);
        
      if ($entity){   
      for ($index = 0; $index < count($entity); $index++) {
        $em->remove($entity[$index]);
        $em->flush();
      }}
      
  // return $this->$entity;
 return $this->redirect($this->generateUrl('Mes_covoiturages'));
    }
    
    
}

?>
