<?php
namespace RayzerCoder\UserBundle\Security\Encoder;
use Symfony\Component\Security\Core\Encoder\BasePasswordEncoder;

class MyPasswordEncoder extends BasePasswordEncoder
{
   public function encodePassword($raw, $salt)
    {
        return md5($raw); // Retourne le mot de passe crypter en md5 sans le salt.
    }
 
    public function isPasswordValid($encoded, $raw, $salt)
    {
        return $this->comparePasswords($encoded, $this->encodePassword($raw, $salt));
    }
}
