<?php

namespace RayzerCoder\UserBundle\Entity;

use Doctrine\ORM\EntityRepository;

class userRepository extends EntityRepository {

    public function findUserByParametres($data) {
        $query = $this->createQueryBuilder('u');

//        $query->where('u.username LIKE :username')
//                ->orWhere('u.firstname LIKE :firstname')
//                ->orWhere('u.lastname Like :lastname')
//                ->setParameters(array(
//                    'username' => $data['username'],
//                    'firstname' => $data['firstname'],
//                    'lastname' => $data['lastname'],
//                    'email' => $data['email'],
//        ));


        if ($data['username'] != '') {
            $query->orWhere('u.username LIKE :username')
                    ->setParameter('username', $data['username']);
        }

        if ($data['nom'] != '') {
            $query->orWhere('u.nom LIKE :nom')
                    ->setParameter('nom', $data['nom']);
        }

        if ($data['prenom'] != '') {
            $query->orWhere('u.prenom LIKE :prenom')
                    ->setParameter('prenom', $data['prenom']);
        }

        if ($data['email'] != '') {
            $query->orWhere('u.email LIKE :email')
                    ->setParameter('email', $data['email']);
        }


        return $query->getQuery()->getResult();
    }

    public function findUserByParametre($data) {
        $query = $this->createQueryBuilder('u');

//        $query->where('u.username LIKE :username')
//                ->orWhere('u.firstname LIKE :firstname')
//                ->orWhere('u.lastname Like :lastname')
//                ->setParameters(array(
//                    'username' => $data['username'],
//                    'firstname' => $data['firstname'],
//                    'lastname' => $data['lastname'],
//                    'email' => $data['email'],
//        ));


        if ($data['recherche'] != '') {
            $query->orWhere('u.username LIKE :recherche')
                    ->setParameter('recherche', $data['recherche']);
        }

        if ($data['recherche'] != '') {
            $query->orWhere('u.nom LIKE :recherche')
                    ->setParameter('recherche', $data['recherche']);
        }

        if ($data['recherche'] != '') {
            $query->orWhere('u.prenom LIKE :recherche')
                    ->setParameter('recherche', $data['recherche']);
        }

        if ($data['recherche'] != '') {
            $query->orWhere('u.email LIKE :recherche')
                    ->setParameter('recherche', $data['recherche']);
        }


        return $query->getQuery()->getResult();
    }

}
