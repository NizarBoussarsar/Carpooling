<?php

namespace Front\MNRSBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Villes
 */
class Villes
{
    /**
     * @var integer
     */
    private $codePostal;

    /**
     * @var string
     */
    private $localite;

    /**
     * @var string
     */
    private $delegation;

    /**
     * @var string
     */
    private $gouvernorat;

    /**
     * @var float
     */
    private $latitude;

    /**
     * @var float
     */
    private $longitude;

    /**
     * @var integer
     */
    private $id;


    /**
     * Set codePostal
     *
     * @param integer $codePostal
     * @return Villes
     */
    public function setCodePostal($codePostal)
    {
        $this->codePostal = $codePostal;

        return $this;
    }

    /**
     * Get codePostal
     *
     * @return integer 
     */
    public function getCodePostal()
    {
        return $this->codePostal;
    }

    /**
     * Set localite
     *
     * @param string $localite
     * @return Villes
     */
    public function setLocalite($localite)
    {
        $this->localite = $localite;

        return $this;
    }

    /**
     * Get localite
     *
     * @return string 
     */
    public function getLocalite()
    {
        return $this->localite;
    }

    /**
     * Set delegation
     *
     * @param string $delegation
     * @return Villes
     */
    public function setDelegation($delegation)
    {
        $this->delegation = $delegation;

        return $this;
    }

    /**
     * Get delegation
     *
     * @return string 
     */
    public function getDelegation()
    {
        return $this->delegation;
    }

    /**
     * Set gouvernorat
     *
     * @param string $gouvernorat
     * @return Villes
     */
    public function setGouvernorat($gouvernorat)
    {
        $this->gouvernorat = $gouvernorat;

        return $this;
    }

    /**
     * Get gouvernorat
     *
     * @return string 
     */
    public function getGouvernorat()
    {
        return $this->gouvernorat;
    }

    /**
     * Set latitude
     *
     * @param float $latitude
     * @return Villes
     */
    public function setLatitude($latitude)
    {
        $this->latitude = $latitude;

        return $this;
    }

    /**
     * Get latitude
     *
     * @return float 
     */
    public function getLatitude()
    {
        return $this->latitude;
    }

    /**
     * Set longitude
     *
     * @param float $longitude
     * @return Villes
     */
    public function setLongitude($longitude)
    {
        $this->longitude = $longitude;

        return $this;
    }

    /**
     * Get longitude
     *
     * @return float 
     */
    public function getLongitude()
    {
        return $this->longitude;
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
    
    private $villea;

    public function getVillea() {
        return $this->villea;
    }

    public function setVillea(\Front\MNRSBundle\Entity\Villes $ville = null) {
        $this->villea = $ville;
    }

    private $villed;

    public function getVilled() {
        return $this->villed;
    }

    public function setVilled(\Front\MNRSBundle\Entity\Villes $ville = null) {
        $this->villed = $ville;
    }
    
    function __toString() {
        return "".$this->codePostal;
    }
}
