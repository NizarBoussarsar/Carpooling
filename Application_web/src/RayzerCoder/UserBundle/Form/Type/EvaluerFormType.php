<?php

namespace RayzerCoder\UserBundle\Form\Type;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;

class EvaluerFormType extends AbstractType {

    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder->add('note', 'number', array('label' => 'Votre note'));
        $builder->add('Evaluer', 'submit');
    }

    public function getName() {
        return 'rayzer_coder_userbundle_simplerecherche';
    }

}
