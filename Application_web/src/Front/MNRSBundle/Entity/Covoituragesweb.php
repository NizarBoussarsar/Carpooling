<?php

namespace Front\MNRSBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Covoituragesweb
 */
class Covoituragesweb
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
     * @var string
     */
    private $positionDepart;

    /**
     * @var string
     */
    private $positionArrivee;

    /**
     * @var float
     */
    private $latDepart;

    /**
     * @var float
     */
    private $latArrivee;

    /**
     * @var float
     */
    private $longDepart;

    /**
     * @var float
     */
    private $longArrivee;

    /**
     * @var integer
     */
    private $nombrePlaces;

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
     * @var \RayzerCoder\UserBundle\Entity\User
     */
    private $idCreateur;


    /**
     * Set titre
     *
     * @param string $titre
     * @return Covoituragesweb
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
     * @return Covoituragesweb
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
     * Set positionDepart
     *
     * @param string $positionDepart
     * @return Covoituragesweb
     */
    public function setPositionDepart($positionDepart)
    {
        $this->positionDepart = $positionDepart;

        return $this;
    }

    /**
     * Get positionDepart
     *
     * @return string 
     */
    public function getPositionDepart()
    {
        return $this->positionDepart;
    }

    /**
     * Set positionArrivee
     *
     * @param string $positionArrivee
     * @return Covoituragesweb
     */
    public function setPositionArrivee($positionArrivee)
    {
        $this->positionArrivee = $positionArrivee;

        return $this;
    }

    /**
     * Get positionArrivee
     *
     * @return string 
     */
    public function getPositionArrivee()
    {
        return $this->positionArrivee;
    }

    /**
     * Set latDepart
     *
     * @param float $latDepart
     * @return Covoituragesweb
     */
    public function setLatDepart($latDepart)
    {
        $this->latDepart = $latDepart;

        return $this;
    }

    /**
     * Get latDepart
     *
     * @return float 
     */
    public function getLatDepart()
    {
        return $this->latDepart;
    }

    /**
     * Set latArrivee
     *
     * @param float $latArrivee
     * @return Covoituragesweb
     */
    public function setLatArrivee($latArrivee)
    {
        $this->latArrivee = $latArrivee;

        return $this;
    }

    /**
     * Get latArrivee
     *
     * @return float 
     */
    public function getLatArrivee()
    {
        return $this->latArrivee;
    }

    /**
     * Set longDepart
     *
     * @param float $longDepart
     * @return Covoituragesweb
     */
    public function setLongDepart($longDepart)
    {
        $this->longDepart = $longDepart;

        return $this;
    }

    /**
     * Get longDepart
     *
     * @return float 
     */
    public function getLongDepart()
    {
        return $this->longDepart;
    }

    /**
     * Set longArrivee
     *
     * @param float $longArrivee
     * @return Covoituragesweb
     */
    public function setLongArrivee($longArrivee)
    {
        $this->longArrivee = $longArrivee;

        return $this;
    }

    /**
     * Get longArrivee
     *
     * @return float 
     */
    public function getLongArrivee()
    {
        return $this->longArrivee;
    }

    /**
     * Set nombrePlaces
     *
     * @param integer $nombrePlaces
     * @return Covoituragesweb
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
     * Set dateCreation
     *
     * @param \DateTime $dateCreation
     * @return Covoituragesweb
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
     * @return Covoituragesweb
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
     * @return Covoituragesweb
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
     * @return Covoituragesweb
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
     * Set prix
     *
     * @param float $prix
     * @return Covoituragesweb
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
     * @return Covoituragesweb
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
     * @return Covoituragesweb
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
     * Set idCreateur
     *
     * @param \RayzerCoder\UserBundle\Entity\User $idCreateur
     * @return Covoituragesweb
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
