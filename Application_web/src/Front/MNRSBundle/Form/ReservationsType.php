<?php

namespace Front\MNRSBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class ReservationsType extends AbstractType
{
        /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('dateReservation')
            ->add('etat')
            ->add('idCovoitureur')
            ->add('idCovoiturage')
        ;
    }
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Front\MNRSBundle\Entity\Reservations'
        ));
    }

    /**
     * @return string
     */
    public function getName()
    {
        return 'front_mnrsbundle_reservations';
    }
}
