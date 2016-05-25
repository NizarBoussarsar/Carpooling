<?php

namespace RayzerCoder\UserBundle\Entity;

use FOS\UserBundle\Model\User as BaseUser;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * @ORM\Entity(repositoryClass="RayzerCoder\UserBundle\Entity\userRepository")
 * @ORM\Table(name="covoitureurs")
 * @ORM\AttributeOverrides({
 *      @ORM\AttributeOverride(name="email",
 *          column=@ORM\Column(
 *              name     = "email",
 *              type     = "string",
 *              length   = 255,
 *              nullable = true
 *          )
 *      ),
 *      @ORM\AttributeOverride(name="password",
 *          column=@ORM\Column(
 *              name     = "mdp",
 *              type     = "string",
 *              length   = 255,
 *              nullable = true
 *          )
 *      ),
 *      @ORM\AttributeOverride(name="username",
 *          column=@ORM\Column(
 *              name     = "nom_utilisateur",
 *              type     = "string",
 *              length   = 255,
 *              nullable = true
 *          )
 *      ),
 * 
 *      @ORM\AttributeOverride(name="confirmationToken",
 *          column=@ORM\Column(
 *              name     = "cle_activation",
 *              type     = "string",
 *              length   = 255,
 *              nullable = true
 *          )
 *      ),
 * @ORM\AttributeOverride(name="lastLogin",
 *          column=@ORM\Column(
 *              name     = "date_derniere_visite",
 *              type     = "datetime",
 *              nullable = true
 *          )
 *      ),
 * 
 * 
 * })
 * 
 * 
 */
class User extends BaseUser {

    /**
     * @ORM\Id
     * @ORM\Column(type="integer")
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    protected $id;

    /**
     * @ORM\Column(name="nom", type="string", length=255,nullable=true)
     *
     * @Assert\NotBlank(message="Please enter your first name.", groups={"Registration", "Profile"})
     * @Assert\Length(
     *     min=3,
     *     max="255",
     *     minMessage="The first name is too short.",
     *     maxMessage="The first name is too long.",
     *     groups={"Registration", "Profile"}
     * )
     */
    protected $nom;

    /**
     * @ORM\Column(name="prenom", type="string", length=255, nullable=true)
     *
     * @Assert\NotBlank(message="Please enter your last name.", groups={"Registration", "Profile"})
     * @Assert\Length(
     *     min=3,
     *     max="255",
     *     minMessage="The last name is too short.",
     *     maxMessage="The last name is too long.",
     *     groups={"Registration", "Profile"}
     * )
     */
    protected $prenom;

    /**
     * @ORM\Column(name="sexe", type="string", length=1, nullable=true)
     */
    protected $sexe;

    /**
     * @ORM\Column(name="fumeur", type="integer", nullable=true)
     */
    protected $fumeur;

    /**
     * @ORM\Column(name="date_naissance", type="date", nullable=true)
     */
    protected $date_naissance;

    /**
     * @ORM\Column(type="string", length=255, nullable=true)
     */
    protected $avatar;

    /**
     * @ORM\Column(type="string", length=255, nullable=true)
     */
    protected $telephone;

    /**
     * @ORM\Column(name="note", type="integer", length=255, nullable=true, options={"default":0})
     */
    protected $note;

    /**
     * @ORM\Column(name="date_enregistrement", type="datetime", nullable=true)
     */
    protected $date_enregistrement;

    /**
     * @Assert\File(maxSize="500k")
     */
    public $file;

    /**
     * @ORM\Column(name="connecte", type="integer", nullable=true)
     */
    public $connecte;

    /**
     * @ORM\Column(name="longitude", type="float", nullable=true)
     */
    protected $longitude;

    /**
     * @ORM\Column(name="latitude", type="float",  nullable=true)
     */
    protected $latitude;

    /**
     * @ORM\Column(name="skype", type="string",length=255, nullable=true)
     */
    protected $skype;

    /**
     * @ORM\Column(name="facebook", type="string",length=255, nullable=true)
     */
    protected $facebook;
    
    /**
     * @ORM\Column(name="id_facebook", type="string",length=255, nullable=true)
     */
    protected $id_facebook;
    
     /**
     * @ORM\Column(name="etat", type="integer", nullable=true)
     */
    protected $etat;
    

    public function getWebPath() {
        return null === $this->avatar ? null : $this->getUploadDir() . '/' . $this->avatar;
    }

    protected function getUploadRootDir() {
// le chemin absolu du répertoire dans lequel sauvegarder les photos de profil
        return __DIR__ . '/../../../../web/' . $this->getUploadDir();
    }

    protected function getUploadDir() {
// get rid of the __DIR__ so it doesn't screw when displaying uploaded doc/image in the view.
        return 'uploads/pictures';
    }

    public function uploadProfilePicture() {
// Nous utilisons le nom de fichier original, donc il est dans la pratique
// nécessaire de le nettoyer pour éviter les problèmes de sécurité
// move copie le fichier présent chez le client dans le répertoire indiqué.
        $this->file->move($this->getUploadRootDir(), $this->file->getClientOriginalName());

// On sauvegarde le nom de fichier
        $this->avatar = $this->file->getClientOriginalName();

// La propriété file ne servira plus
        $this->file = null;
    }

    public function __construct() {
        parent::__construct();
        $this->note = 0;
        $this->setDateEnregistrement(new \DateTime("now"));
        $this->avatar = "avatar.jpg";
    }

    public function getId() {
        return $this->id;
    }

    public function setId($id) {
        $this->id = $id;
    }

    public function getNom() {
        return $this->nom;
    }

    public function setNom($nom) {
        $this->nom = $nom;
    }

    public function getPrenom() {
        return $this->prenom;
    }

    public function setPrenom($prenom) {
        $this->prenom = $prenom;
    }

    public function getSexe() {
        return $this->sexe;
    }

    public function setSexe($sexe) {
        $this->sexe = $sexe;
    }

    public function getFumeur() {
        return $this->fumeur;
    }

    public function setFumeur($fumeur) {
        $this->fumeur = $fumeur;
    }

    public function getDateNaissance() {
        return $this->date_naissance;
    }

    public function setDateNaissance($date_naissance) {
        $this->date_naissance = $date_naissance;
    }

    public function getAvatar() {
        return $this->avatar;
    }

    public function setAvatar($avatar) {
        $this->avatar = $avatar;
    }

    public function getTelephone() {
        return $this->telephone;
    }

    public function setTelephone($telephone) {
        $this->telephone = $telephone;
    }

    public function getNote() {
        return $this->note;
    }

    public function setNote($note) {
        $this->note = $note;
    }

    public function getDateEnregistrement() {
        return $this->date_enregistrement;
    }

    public function setDateEnregistrement($date_enregistrement) {
        $this->date_enregistrement = $date_enregistrement;
    }

    public function getFile() {
        return $this->file;
    }

    public function setFile($file) {
        $this->file = $file;
    }

    public function getConnecte() {
        return $this->connecte;
    }

    public function setConnecte($connecte) {
        $this->connecte = $connecte;
    }

    public function getLongitude() {
        return $this->longitude;
    }

    public function setLongitude($longitude) {
        $this->longitude = $longitude;
    }

    public function getLatitude() {
        return $this->latitude;
    }

    public function setLatitude($latitude) {
        $this->latitude = $latitude;
    }

    public function getSkype() {
        return $this->skype;
    }

    public function setSkype($skype) {
        $this->skype = $skype;
    }

    public function getFacebook() {
        return $this->facebook;
    }

    public function setFacebook($facebook) {
        $this->facebook = $facebook;
    }

    public function getIdFacebook() {
        return $this->id_facebook;
    }

    public function setIdFacebook($id_facebook) {
        $this->id_facebook = $id_facebook;
    }
    public function getEtat() {
        return $this->etat;
    }

    public function setEtat($etat) {
        $this->etat = $etat;
    }




}
