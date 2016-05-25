<?php

namespace Front\MNRSBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class mapController extends Controller {

    public function mapAction() {
        $em = $this->getDoctrine()->getManager();

        $covoitureur = $em->getRepository('RayzerCoderUserBundle:User')->find($this->getUser()->getId());
        $covoiturage = new \Front\MNRSBundle\Entity\Covoituragesweb();

        //Récupérer les variables à partir du formulaire
        $Request = $this->getRequest();
        if ($Request->getMethod() == 'POST') {
            $titre = $Request->get("titre");
            $description = $Request->get("description");
            $positionDepart = $Request->get("positionDepart");
            $positionArrivee = $Request->get("positionArrivee");
            $LatvilleDep = $Request->get("LatvilleDep");
            $LatvilleArr = $Request->get("LatvilleArr");
            $LongvilleDep = $Request->get("LongvilleDep");
            $LongvilleArr = $Request->get("LongvilleArr");
            $nombrePlaces = $Request->get("nombrePlaces");
            $prix = $Request->get("prix");
            $dateDepart = $Request->get("datestring");
            $heureDepart = $Request->get("timestring");
            $fumeur = $Request->get("fumeur");
            $reserveeFemmes = $Request->get("reserveeFemmes");

            $bb = new \DateTime($dateDepart);
            $aa = new \DateTime($heureDepart);

            //Insérer les données dans les entités
            $covoiturage->setTitre($titre);
            $covoiturage->setDescription($description);
            $covoiturage->setIdCreateur($covoitureur);
            $covoiturage->setPositionDepart($positionDepart);
            $covoiturage->setPositionArrivee($positionArrivee);
            $covoiturage->setLatDepart($LatvilleDep);
            $covoiturage->setLatArrivee($LatvilleArr);
            $covoiturage->setLongDepart($LongvilleDep);
            $covoiturage->setLongArrivee($LongvilleArr);
            $covoiturage->setNombrePlaces($nombrePlaces);
            $covoiturage->setPrix($prix);
            $covoiturage->setDateDepart($bb);
            $covoiturage->setHeureDepart($aa);
            $covoiturage->setFumeur($fumeur);
            $covoiturage->setReserveeFemmes($reserveeFemmes);
            $covoiturage->setDateCreation(new \DateTime);
            $covoiturage->setDateMiseajour(new \DateTime);
            $em->persist($covoiturage);
            $em->flush();
        }
        return $this->render('FrontMNRSBundle:map:map.html.twig');
    }

    public function rechercheAction() {
        $Request = $this->getRequest();
        if ($Request->getMethod() == 'POST') {
            $positionDepart = $Request->get("positionDepart");
            $positionArrivee = $Request->get("positionArrivee");


            $em = $this->getDoctrine()->getManager();

            $query = $em->createQuery("SELECT c FROM FrontMNRSBundle:Covoituragesweb c WHERE (c.positionDepart = :posd AND  c.positionArrivee = :posa)");
            $query->setParameter('posd', $positionDepart);
            $query->setParameter('posa', $positionArrivee);

            $covoiturages = $query->getResult();
            return $this->render('FrontMNRSBundle:map:resultatmap.html.twig', array('covoiturages' => $covoiturages));
        }
        return $this->render('FrontMNRSBundle:map:recherchemap.html.twig');
    }

}

