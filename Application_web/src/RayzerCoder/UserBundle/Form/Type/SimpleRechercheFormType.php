<?php


namespace RayzerCoder\UserBundle\Form\Type;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;


class SimpleRechercheFormType extends AbstractType {

    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
        ->add('recherche', 'text');
    }

    public function getName() {
        return 'rayzer_coder_userbundle_simplerecherche';
    }

}
