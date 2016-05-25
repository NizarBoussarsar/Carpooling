<?php

namespace Front\MNRSBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Messages
 */
class Messages
{
    /**
     * @var string
     */
    private $objet;

    /**
     * @var string
     */
    private $contenu;

    /**
     * @var \DateTime
     */
    private $dateEnvoie;

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
     * Set objet
     *
     * @param string $objet
     * @return Messages
     */
    public function setObjet($objet)
    {
        $this->objet = $objet;

        return $this;
    }

    /**
     * Get objet
     *
     * @return string 
     */
    public function getObjet()
    {
        return $this->objet;
    }

    /**
     * Set contenu
     *
     * @param string $contenu
     * @return Messages
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
     * Set dateEnvoie
     *
     * @param \DateTime $dateEnvoie
     * @return Messages
     */
    public function setDateEnvoie($dateEnvoie)
    {
        $this->dateEnvoie = $dateEnvoie;

        return $this;
    }

    /**
     * Get dateEnvoie
     *
     * @return \DateTime 
     */
    public function getDateEnvoie()
    {
        return $this->dateEnvoie;
    }

    /**
     * Set lu
     *
     * @param boolean $lu
     * @return Messages
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
     * @return Messages
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
     * @return Messages
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
