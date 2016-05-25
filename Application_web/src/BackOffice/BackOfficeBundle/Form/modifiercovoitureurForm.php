<?php

namespace BackOffice\BackOfficeBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;

class modifiercovoitureurForm extends AbstractType {

    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
                ->add('username', 'text')
                ->add('nom', 'text')
                ->add('prenom', 'text')
                ->add('etat', 'choice', array(
                    'choices' => array('0' => 'Bloqué', '1' => 'En Atente', '2' => 'Actif')));
    }

    public function getName() {
        return 'covoitureurModif';
    }

}

