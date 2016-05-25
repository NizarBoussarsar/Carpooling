<?php

namespace Front\MNRSBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Covoiturages
 */
class Covoiturages
{
    /**
     * @var string
     */
    private $titre;

    /**
     * @var string
     */
    private $description;

    /**
     * @var \DateTime
     */
    private $dateCreation;

    /**
     * @var \DateTime
     */
    private $dateMiseajour;

    /**
     * @var \DateTime
     */
    private $dateDepart;

    /**
     * @var \DateTime
     */
    private $heureDepart;

    /**
     * @var integer
     */
    private $nombrePlaces;

    /**
     * @var float
     */
    private $prix;

    /**
     * @var boolean
     */
    private $fumeur;

    /**
     * @var boolean
     */
    private $reserveeFemmes;

    /**
     * @var integer
     */
    private $id;

    /**
     * @var \Front\MNRSBundle\Entity\Villes
     */
    private $idVilleDepart;

    /**
     * @var \Front\MNRSBundle\Entity\Villes
     */
    private $idVilleArrivee;

    /**
     * @var \RayzerCoder\UserBundle\Entity\User
     */
    private $idCreateur;


    /**
     * Set titre
     *
     * @param string $titre
     * @return Covoiturages
     */
    public function setTitre($titre)
    {
        $this->titre = $titre;

        return $this;
    }

    /**
     * Get titre
     *
     * @return string 
     */
    public function getTitre()
    {
        return $this->titre;
    }

    /**
     * Set description
     *
     * @param string $description
     * @return Covoiturages
     */
    public function setDescription($description)
    {
        $this->description = $description;

        return $this;
    }

    /**
     * Get description
     *
     * @return string 
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * Set dateCreation
     *
     * @param \DateTime $dateCreation
     * @return Covoiturages
     */
    public function setDateCreation($dateCreation)
    {
        $this->dateCreation = $dateCreation;

        return $this;
    }

    /**
     * Get dateCreation
     *
     * @return \DateTime 
     */
    public function getDateCreation()
    {
        return $this->dateCreation;
    }

    /**
     * Set dateMiseajour
     *
     * @param \DateTime $dateMiseajour
     * @return Covoiturages
     */
    public function setDateMiseajour($dateMiseajour)
    {
        $this->dateMiseajour = $dateMiseajour;

        return $this;
    }

    /**
     * Get dateMiseajour
     *
     * @return \DateTime 
     */
    public function getDateMiseajour()
    {
        return $this->dateMiseajour;
    }

    /**
     * Set dateDepart
     *
     * @param \DateTime $dateDepart
     * @return Covoiturages
     */
    public function setDateDepart($dateDepart)
    {
        $this->dateDepart = $dateDepart;

        return $this;
    }

    /**
     * Get dateDepart
     *
     * @return \DateTime 
     */
    public function getDateDepart()
    {
        return $this->dateDepart;
    }

    /**
     * Set heureDepart
     *
     * @param \DateTime $heureDepart
     * @return Covoiturages
     */
    public function setHeureDepart($heureDepart)
    {
        $this->heureDepart = $heureDepart;

        return $this;
    }

    /**
     * Get heureDepart
     *
     * @return \DateTime 
     */
    public function getHeureDepart()
    {
        return $this->heureDepart;
    }

    /**
     * Set nombrePlaces
     *
     * @param integer $nombrePlaces
     * @return Covoiturages
     */
    public function setNombrePlaces($nombrePlaces)
    {
        $this->nombrePlaces = $nombrePlaces;

        return $this;
    }

    /**
     * Get nombrePlaces
     *
     * @return integer 
     */
    public function getNombrePlaces()
    {
        return $this->nombrePlaces;
    }

    /**
     * Set prix
     *
     * @param float $prix
     * @return Covoiturages
     */
    public function setPrix($prix)
    {
        $this->prix = $prix;

        return $this;
    }

    /**
     * Get prix
     *
     * @return float 
     */
    public function getPrix()
    {
        return $this->prix;
    }

    /**
     * Set fumeur
     *
     * @param boolean $fumeur
     * @return Covoiturages
     */
    public function setFumeur($fumeur)
    {
        $this->fumeur = $fumeur;

        return $this;
    }

    /**
     * Get fumeur
     *
     * @return boolean 
     */
    public function getFumeur()
    {
        return $this->fumeur;
    }

    /**
     * Set reserveeFemmes
     *
     * @param boolean $reserveeFemmes
     * @return Covoiturages
     */
    public function setReserveeFemmes($reserveeFemmes)
    {
        $this->reserveeFemmes = $reserveeFemmes;

        return $this;
    }

    /**
     * Get reserveeFemmes
     *
     * @return boolean 
     */
    public function getReserveeFemmes()
    {
        return $this->reserveeFemmes;
    }

    /**
     * Get id
     *
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set idVilleDepart
     *
     * @param \Front\MNRSBundle\Entity\Villes $idVilleDepart
     * @return Covoiturages
     */
    public function setIdVilleDepart(\Front\MNRSBundle\Entity\Villes $idVilleDepart = null)
    {
        $this->idVilleDepart = $idVilleDepart;

        return $this;
    }

    /**
     * Get idVilleDepart
     *
     * @return \Front\MNRSBundle\Entity\Villes 
     */
    public function getIdVilleDepart()
    {
        return $this->idVilleDepart;
    }

    /**
     * Set idVilleArrivee
     *
     * @param \Front\MNRSBundle\Entity\Villes $idVilleArrivee
     * @return Covoiturages
     */
    public function setIdVilleArrivee(\Front\MNRSBundle\Entity\Villes $idVilleArrivee = null)
    {
        $this->idVilleArrivee = $idVilleArrivee;

        return $this;
    }

    /**
     * Get idVilleArrivee
     *
     * @return \Front\MNRSBundle\Entity\Villes 
     */
    public function getIdVilleArrivee()
    {
        return $this->idVilleArrivee;
    }

    /**
     * Set idCreateur
     *
     * @param \RayzerCoder\UserBundle\Entity\User $idCreateur
     * @return Covoiturages
     */
    public function setIdCreateur(\RayzerCoder\UserBundle\Entity\User $idCreateur = null)
    {
        $this->idCreateur = $idCreateur;

        return $this;
    }

    /**
     * Get idCreateur
     *
     * @return \RayzerCoder\UserBundle\Entity\User 
     */
    public function getIdCreateur()
    {
        return $this->idCreateur;
    }
}
