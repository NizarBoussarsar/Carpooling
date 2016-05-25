<?php

namespace Front\MNRSBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Notifications
 */
class Notifications
{
    /**
     * @var \DateTime
     */
    private $dateCreation;

    /**
     * @var string
     */
    private $contenu;

    /**
     * @var integer
     */
    private $type;

    /**
     * @var boolean
     */
    private $lu;

    /**
     * @var integer
     */
    private $id;

    /**
     * @var \RayzerCoder\UserBundle\Entity\User
     */
    private $idExpediteur;

    /**
     * @var \RayzerCoder\UserBundle\Entity\User
     */
    private $idDestinataire;


    /**
     * Set dateCreation
     *
     * @param \DateTime $dateCreation
     * @return Notifications
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
     * Set contenu
     *
     * @param string $contenu
     * @return Notifications
     */
    public function setContenu($contenu)
    {
        $this->contenu = $contenu;

        return $this;
    }

    /**
     * Get contenu
     *
     * @return string 
     */
    public function getContenu()
    {
        return $this->contenu;
    }

    /**
     * Set type
     *
     * @param integer $type
     * @return Notifications
     */
    public function setType($type)
    {
        $this->type = $type;

        return $this;
    }

    /**
     * Get type
     *
     * @return integer 
     */
    public function getType()
    {
        return $this->type;
    }

    /**
     * Set lu
     *
     * @param boolean $lu
     * @return Notifications
     */
    public function setLu($lu)
    {
        $this->lu = $lu;

        return $this;
    }

    /**
     * Get lu
     *
     * @return boolean 
     */
    public function getLu()
    {
        return $this->lu;
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
     * Set idExpediteur
     *
     * @param \RayzerCoder\UserBundle\Entity\User $idExpediteur
     * @return Notifications
     */
    public function setIdExpediteur(\RayzerCoder\UserBundle\Entity\User $idExpediteur = null)
    {
        $this->idExpediteur = $idExpediteur;

        return $this;
    }

    /**
     * Get idExpediteur
     *
     * @return \RayzerCoder\UserBundle\Entity\User 
     */
    public function getIdExpediteur()
    {
        return $this->idExpediteur;
    }

    /**
     * Set idDestinataire
     *
     * @param \RayzerCoder\UserBundle\Entity\User $idDestinataire
     * @return Notifications
     */
    public function setIdDestinataire(\RayzerCoder\UserBundle\Entity\User $idDestinataire = null)
    {
        $this->idDestinataire = $idDestinataire;

        return $this;
    }

    /**
     * Get idDestinataire
     *
     * @return \RayzerCoder\UserBundle\Entity\User 
     */
    public function getIdDestinataire()
    {
        return $this->idDestinataire;
    }
}
