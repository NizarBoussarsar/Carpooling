<?php

namespace RayzerCoder\UserBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;

class IdentityPictureType extends AbstractType {

    public function buildForm(FormBuilderInterface $builder, array $options) {
        parent::buildForm($builder, $options);
        $builder->add('file');
    }

    public function getName() {
        return 'rayzer_coder_userbundle_identitypicturetype';
    }

}
