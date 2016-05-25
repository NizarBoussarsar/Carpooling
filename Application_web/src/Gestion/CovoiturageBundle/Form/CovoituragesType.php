<?php

namespace Gestion\CovoiturageBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class CovoituragesType extends AbstractType
{
        /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('titre')
            ->add('description')
            ->add('dateCreation')
            ->add('dateMiseajour')
            ->add('dateDepart')
            ->add('heureDepart')
            ->add('nombrePlaces')
            ->add('prix')
            ->add('fumeur')
            ->add('reserveeFemmes')
//            ->add('idVilleDepart')
//            ->add('idVilleArrivee')
//            ->add('idCreateur')
        ;
    }
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Front\MNRSBundle\Entity\Covoiturages'
        ));
    }

    /**
     * @return string
     */
    public function getName()
    {
        return 'gestion_covoituragebundle_covoiturages';
    }
}
