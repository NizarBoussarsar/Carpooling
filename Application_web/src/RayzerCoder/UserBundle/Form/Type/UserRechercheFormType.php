<?php

namespace RayzerCoder\UserBundle\Form\Type;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;

class UserRechercheFormType extends AbstractType {

    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
                ->add('username', 'text', array('label' => 'Nom utilisateur'))
                ->add('nom', 'text', array('label' => 'Nom'))
                ->add('prenom', 'text', array('label' => 'Prenom'))
                ->add('email', 'text', array('label' => 'Email'));
                
    }

    public function getName() {
        return 'rayzer_coder_userbundle_userrecherche';
    }

}
