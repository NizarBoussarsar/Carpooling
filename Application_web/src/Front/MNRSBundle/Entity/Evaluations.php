<?php

namespace Front\MNRSBundle\Entity;

/**
 * Evaluations
 */
class Evaluations
{
    /**
     * @var string
     */
    private $message;

    /**
     * @var integer
     */
    private $note;

    /**
     * @var \DateTime
     */
    private $dateEvaluation;

    /**
     * @var integer
     */
    private $id;

    /**
     * @var \RayzerCoder\UserBundle\Entity\User
     */
    private $idEvaluateur;

    /**
     * @var \Front\MNRSBundle\Entity\Covoiturages
     */
    private $idCovoiturage;


    /**
     * Set message
     *
     * @param string $message
     * @return Evaluations
     */
    public function setMessage($message)
    {
        $this->message = $message;

        return $this;
    }

    /**
     * Get message
     *
     * @return string 
     */
    public function getMessage()
    {
        return $this->message;
    }

    /**
     * Set note
     *
     * @param integer $note
     * @return Evaluations
     */
    public function setNote($note)
    {
        $this->note = $note;

        return $this;
    }

    /**
     * Get note
     *
     * @return integer 
     */
    public function getNote()
    {
        return $this->note;
    }

    /**
     * Set dateEvaluation
     *
     * @param \DateTime $dateEvaluation
     * @return Evaluations
     */
    public function setDateEvaluation($dateEvaluation)
    {
        $this->dateEvaluation = $dateEvaluation;

        return $this;
    }

    /**
     * Get dateEvaluation
     *
     * @return \DateTime 
     */
    public function getDateEvaluation()
    {
        return $this->dateEvaluation;
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
     * Set idEvaluateur
     *
     * @param \RayzerCoder\UserBundle\Entity\User $idEvaluateur
     * @return Evaluations
     */
    public function setIdEvaluateur(\RayzerCoder\UserBundle\Entity\User $idEvaluateur = null)
    {
        $this->idEvaluateur = $idEvaluateur;

        return $this;
    }

    /**
     * Get idEvaluateur
     *
     * @return \RayzerCoder\UserBundle\Entity\User 
     */
    public function getIdEvaluateur()
    {
        return $this->idEvaluateur;
    }

    /**
     * Set idCovoiturage
     *
     * @param \Front\MNRSBundle\Entity\Covoiturages $idCovoiturage
     * @return Evaluations
     */
    public function setIdCovoiturage(\Front\MNRSBundle\Entity\Covoiturages $idCovoiturage = null)
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
