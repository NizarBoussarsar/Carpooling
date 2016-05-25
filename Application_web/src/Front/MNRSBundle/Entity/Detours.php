<?php

namespace Front\MNRSBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Detours
 */
class Detours
{
    /**
     * @var integer
     */
    private $id;

    /**
     * @var \Front\MNRSBundle\Entity\Villes
     */
    private $idVille;

    /**
     * @var \Front\MNRSBundle\Entity\Covoiturages
     */
    private $idCovoiturage;


    /**
     * Set id
     *
     * @param integer $id
     * @return Detours
     */
    public function setId($id)
    {
        $this->id = $id;

        return $this;
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
     * Set idVille
     *
     * @param \Front\MNRSBundle\Entity\Villes $idVille
     * @return Detours
     */
    public function setIdVille(\Front\MNRSBundle\Entity\Villes $idVille)
    {
        $this->idVille = $idVille;

        return $this;
    }

    /**
     * Get idVille
     *
     * @return \Front\MNRSBundle\Entity\Villes 
     */
    public function getIdVille()
    {
        return $this->idVille;
    }

    /**
     * Set idCovoiturage
     *
     * @param \Front\MNRSBundle\Entity\Covoiturages $idCovoiturage
     * @return Detours
     */
    public function setIdCovoiturage(\Front\MNRSBundle\Entity\Covoiturages $idCovoiturage)
    {
        $this->idCovoiturage = $idCovoiturage;

        return $this;
    }

    /**
     * Get idCovoiturage
     *
     * @return \Front\MNRSBundle\Entity\Covoiturages 
     */
    public function getIdCovoiturage()
    {
        return $this->idCovoiturage;
    }
}
