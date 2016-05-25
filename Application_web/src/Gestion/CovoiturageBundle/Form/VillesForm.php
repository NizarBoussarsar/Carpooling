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
 * Description of VillesForm
 *
 * @author Hhussein
 */
class VillesForm extends AbstractType {

    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
               // ->add('gouvernorat')
                ->add('localite','entity',array(
                    'class'=>'GestionCovoiturageBundle:Villes',
                    'property' =>'localite',
                    'multiple' =>false)
                        );
             /*  ->add('delegation','entity',array(
                    'class'=>'GestionCovoiturageBundle:Villes',
                    'property' =>'delegation',
                    'multiple' =>true)
                        )
                 ->add('gouvernorat','entity',array(
                    'class'=>'GestionCovoiturageBundle:Villes',
                    'property' =>'gouvernorat',
                    'multiple' =>true)
                        );*/
       
    }

    public function getName() {
        return 'Villes';
    }

}

?>
