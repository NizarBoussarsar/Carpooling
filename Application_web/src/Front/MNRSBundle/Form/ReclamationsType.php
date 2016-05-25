<?php

namespace Front\MNRSBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class ReclamationsType extends AbstractType {

    /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
                ->add('email', 'email', array('required' => true))
                ->add('nomUtilisateur', 'text')
                ->add('type', 'choice', array(
                    'choices' => array(
                        '0' => '',
                        '1' => 'Signaler un covoitureur',
                        '2' => 'Suggérer des améliorations',
                        '3' => 'Type 3',
                        '4' => 'Type 4'),
                    'required' => true))
                ->add('message', 'textarea', array(
                    'attr' => array('cols' => '50', 'rows' => '10'),
                    'required' => true))
        ;
    }

    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver) {
        $resolver->setDefaults(array(
            'data_class' => 'Front\MNRSBundle\Entity\Reclamations'
        ));
    }

    /**
     * @return string
     */
    public function getName() {
        return 'front_mnrsbundle_reclamations';
    }

}
