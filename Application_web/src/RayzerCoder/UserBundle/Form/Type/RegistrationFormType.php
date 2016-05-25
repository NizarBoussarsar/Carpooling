<?php

namespace RayzerCoder\UserBundle\Form\Type;

use Symfony\Component\Form\FormBuilderInterface;
use FOS\UserBundle\Form\Type\RegistrationFormType as BaseType;

class RegistrationFormType extends BaseType {

    public function buildForm(FormBuilderInterface $builder, array $options) {
        parent::buildForm($builder, $options);
        $builder->add('nom', 'text', array('label' => 'Nom'));
        $builder->add('prenom', 'text', array('label' => 'Prenom'));
            $builder->add('date_naissance', 'date', array('years' => range(1920, date('Y'))));
        $builder->add('sexe', 'choice', array(
            'choices' => array(
                'H' => 'Homme',
                'F' => 'Femme'
            ),'label'=>'Sexe',
            'required' => true,
            'empty_value' => 'Choisir vote sexe',
            'empty_data' => null
        ));
        
         $builder->add('fumeur', 'choice', array(
            'choices' => array(
                '0' => 'Non',
                '1' => 'Oui'
            ),'label'=>'Fumeur',
            'required' => true,
            'empty_value' => 'Fumeur ou non?',
            'empty_data' => null
        ));
         
          $builder->add('telephone', 'number', array('label' => 'Numero telephone'));
    }

    public function getName() {
        return 'rayzer_coder_user_registration';
    }

}
