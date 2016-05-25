<?php

namespace Front\MNRSBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Participants
 */
class Participants
{
    /**
     * @var \DateTime
     */
    private $dateParticipation;

    /**
     * @var integer
     */
    private $id;

    /**
     * @var \RayzerCoder\UserBundle\Entity\User
     */
    private $idParticipant;

    /**
     * @var \Front\MNRSBundle\Entity\Covoiturages
     */
    private $idCovoiturage;


    /**
     * Set dateParticipation
     *
     * @param \DateTime $dateParticipation
     * @return Participants
     */
    public function setDateParticipation($dateParticipation)
    {
        $this->dateParticipation = $dateParticipation;

        return $this;
    }

    /**
     * Get dateParticipation
     *
     * @return \DateTime 
     */
    public function getDateParticipation()
    {
        return $this->dateParticipation;
    }

    /**
     * Set id
     *
     * @param integer $id
     * @return Participants
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
     * Set idParticipant
     *
     * @param \RayzerCoder\UserBundle\Entity\User$idParticipant
     * @return Participants
     */
    public function setIdParticipant(RayzerCoder\UserBundle\Entity\User $idParticipant)
    {
        $this->idParticipant = $idParticipant;

        return $this;
    }

    /**
     * Get idParticipant
     *
     * @return \RayzerCoder\UserBundle\Entity\User 
     */
    public function getIdParticipant()
    {
        return $this->idParticipant;
    }

    /**
     * Set idCovoiturage
     *
     * @param \Front\MNRSBundle\Entity\Covoiturages $idCovoiturage
     * @return Participants
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
