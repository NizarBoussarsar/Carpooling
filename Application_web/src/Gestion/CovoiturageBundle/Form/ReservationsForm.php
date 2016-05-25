<?php
namespace Gestion\CovoiturageBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of ReservationsForm
 *
 * @author Hhussein
 */
class ReservationsForm extends AbstractType{
      public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('dateReservation')
            ->add('etat')
            ->add('idCovoitureur')
            ->add('idCovoiturage')
        ;
    }

        public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Gestion\CovoiturageBundle\Entity\Reservations'
        ));
    }
      public function getName()
    {
        return 'Reservations';
    }
    }

?>
