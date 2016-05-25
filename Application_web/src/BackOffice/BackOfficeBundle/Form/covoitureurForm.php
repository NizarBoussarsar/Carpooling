<?php

namespace BackOffice\BackOfficeBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;

class CovoitureurForm extends AbstractType {

    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
                ->add('email', 'email')
                ->add('username', 'text')
                ->add('nom', 'text')
                ->add('prenom', 'text')
                ->add('password', 'password')
                ->add('telephone', 'number')
                ->add('sexe', 'choice', array(
                    'choices' => array('m' => 'Masculin', 'f' => 'Féminin')))
                ->add('date_naissance', 'birthday', array(
                    'input' => 'datetime',
                    'widget' => 'choice'))
                ->add('etat', 'choice', array(
                    'choices' => array('0' => 'Bloqué', '1' => 'En Atente', '2' => 'Actif')));
    }

    public function getName() {
        return 'Covoitureur';
    }

}

