<?php

namespace Front\MNRSBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reservations
 */
class Reservations {

    /**
     * @var \DateTime
     */
    private $dateReservation;

    /**
     * @var boolean
     */
    private $etat;

    /**
     * @var integer
     */
    private $id;

    /**
     * @var \RayzerCoder\UserBundle\Entity\User
     */
    private $idCovoitureur;

    /**
     * @var \Front\MNRSBundle\Entity\Covoiturages
     */
    private $idCovoiturage;

    /**
     * Set dateReservation
     *
     * @param \DateTime $dateReservation
     * @return Reservations
     */
    public function setDateReservation($dateReservation) {
        $this->dateReservation = $dateReservation;

        return $this;
    }

    /**
     * Get dateReservation
     *
     * @return \DateTime 
     */
    public function getDateReservation() {
        return $this->dateReservation;
    }

    /**
     * Set etat
     *
     * @param boolean $etat
     * @return Reservations
     */
    public function setEtat($etat) {
        $this->etat = $etat;

        return $this;
    }

    /**
     * Get etat
     *
     * @return boolean 
     */
    public function getEtat() {
        return $this->etat;
    }

    /**
     * Get id
     *
     * @return integer 
     */
    public function getId() {
        return $this->id;
    }

    /**
     * Set idCovoitureur
     *
     * @param \RayzerCoder\UserBundle\Entity\User $idCovoitureur
     * @return Reservations
     */
    public function setIdCovoitureur(\RayzerCoder\UserBundle\Entity\User $idCovoitureur = null) {
        $this->idCovoitureur = $idCovoitureur;

        return $this;
    }

    /**
     * Get idCovoitureur
     *
     * @return \RayzerCoder\UserBundle\Entity\User 
     */
    public function getIdCovoitureur() {
        return $this->idCovoitureur;
    }

    /**
     * Set idCovoiturage
     *
     * @param \Front\MNRSBundle\Entity\Covoiturages $idCovoiturage
     * @return Reservations
     */
    public function setIdCovoiturage(\Front\MNRSBundle\Entity\Covoiturages $idCovoiturage = null) {
        $this->idCovoiturage = $idCovoiturage;

        return $this;
    }

    /**
     * Get idCovoiturage
     *
     * @return \Front\MNRSBundle\Entity\Covoiturages 
     */
    public function getIdCovoiturage() {
        return $this->idCovoiturage;
    }

    public function __toString() {
        return "" . $this->id;
    }

}
