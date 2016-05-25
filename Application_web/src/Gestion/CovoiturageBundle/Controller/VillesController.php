<?php

namespace Gestion\CovoiturageBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Gestion\CovoiturageBundle\Entity\Villes;
use Gestion\CovoiturageBundle\Form\VillesForm;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of VillesController
 *
 * @author Hhussein
 */
class VillesController extends Controller {

    public function ListVillesAction() {

        $em = $this->container->get('Doctrine')->getEntityManager();
        $Villes = $em->getRepository('FrontMNRSBundle:Villes')->findAll();
        return $this->render('GestionCovoiturageBundle:Villes:index.html.twig', array(
                    'entities' => $Villes
        ));
    }

    public function AjoutVillesAction() {

        $Ville = new Villes();
        $form = $this->container->get('form.factory')->create(new VillesForm(), $Ville);

        $request = $this->getRequest();

        echo"avant a un poste";
        if ($request->getMethod() == "POST") {
            echo"suite a un poste";
            $form->bind($request); //recupereer les donnee au niveau formulaire 
            // if ($form->isValid()) {
            echo"suite a un poste";
            $em = $this->container->get('Doctrine')->getEntityManager();
            $em->persist($Ville); // INSERT fil cache 
            $em->flush(); // commit       validation de insertion    

            return $this->redirect($this->generateUrl('villes')); // rederection ficher routing
            //  }
        }


        return $this->render('GestionCovoiturageBundle:Villes:new.html.twig', array(
                    'form' => $form->createView()
        ));
    }

    public function FindlocaliteAction($search2) {
        /* rech localite selon gouvernorat */

        $em = $this->getDoctrine()->getManager();
        $Request = $this->getRequest();
        $ville = new Villes();

        if ('GET' == $Request->getMethod()) {
            //   $search2 = $Request->get('search');
            $query = $em->createQuery(
                            'SELECT DISTINCT v
                         FROM FrontMNRSBundle:Villes v 
                         WHERE v.delegation LIKE :d '
                    )->setParameter('d', $search2);


            $ville = $query->getResult();
            return $ville;


            //    return array('entities' => $ville);
        }
        return $ville;
        // return array('localites' => $ville);
    }

    public function FinddelegationAction($search1) {
        /* rech delegation selon localite */

        $em = $this->getDoctrine()->getManager();
        $Request = $this->getRequest();
        $ville = new Villes();

        if ('GET' == $Request->getMethod()) {

            echo "*****" . $search1;
            $query = $em->createQuery(
                            'SELECT DISTINCT v
                         FROM FrontMNRSBundle:Villes v 
                         WHERE v.gouvernorat LIKE :d '
                    )->setParameter('d', $search1);


            $ville = $query->getResult();
            return $ville;
        }

        //   return array('entities' => $ville);

        return $ville;
    }

    public function FindgouvernoratAction() {

        $em = $this->getDoctrine()->getManager();
        $Request = $this->getRequest();
        $ville = new Villes();
        $delegation = new Villes();
        $localite = new Villes();
        if ('GET' == $Request->getMethod()) {

            $search1 = $Request->get('search1');
            $search2 = $Request->get('search2');
            $query = $em->createQuery(
                    'SELECT DISTINCT v.gouvernorat
                         FROM FrontMNRSBundle:Villes v  ');

            $ville = $query->getResult();

            echo "***test valeur search1**" . $search1;
            echo "***test valeur search2**" . $search2;
            $delegation = $this->FinddelegationAction($search1);
            $localite = $this->FindlocaliteAction($search2);


            return $this->render('GestionCovoiturageBundle:Villes:rech.html.twig', array(
                        'entities' => $ville,
                        'delegations' => $delegation,
                        'localites' => $localite,
                        'search1' => $search1,
                        'search2' => $search2
            ));
        }

        return $this->render('GestionCovoiturageBundle:Villes:rech.html.twig', array(
                    'entities' => $ville,
                    'delegations' => $delegation,
                    'localites' => $localite,
                    'search1' => $search1,
                    'search2' => $search2
        ));
    }

}