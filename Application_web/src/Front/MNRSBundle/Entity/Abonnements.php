<?php

namespace Front\MNRSBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Abonnements
 */
class Abonnements
{
    /**
     * @var boolean
     */
    private $etat;

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
    private $idCovoitureur;


    /**
     * Set etat
     *
     * @param boolean $etat
     * @return Abonnements
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;

        return $this;
    }

    /**
     * Get etat
     *
     * @return boolean 
     */
    public function getEtat()
    {
        return $this->etat;
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
     * @return Abonnements
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
     * @return Abonnements
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
     * Set idCovoitureur
     *
     * @param \RayzerCoder\UserBundle\Entity\User $idCovoitureur
     * @return Abonnements
     */
    public function setIdCovoitureur(\RayzerCoder\UserBundle\Entity\User $idCovoitureur = null)
    {
        $this->idCovoitureur = $idCovoitureur;

        return $this;
    }

    /**
     * Get idCovoitureur
     *
     * @return \RayzerCoder\UserBundle\Entity\User 
     */
    public function getIdCovoitureur()
    {
        return $this->idCovoitureur;
    }
}
