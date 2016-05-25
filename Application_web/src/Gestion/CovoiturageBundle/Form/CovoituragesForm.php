<?php

namespace Gestion\CovoiturageBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;
use Gestion\CovoiturageBundle\Form\VillesForm;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of CovoituragesForm
 *
 * @author Hhussein
 */
class CovoituragesForm extends AbstractType {

    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
                ->add('titre')
                ->add('description')
                ->add('dateDepart')
                ->add('heureDepart')
                ->add('nombrePlaces')
                ->add('prix')
                ->add('fumeur')
                ->add('reserveeFemmes')
                ->add('idVilleDepart')
                ->add('idVilleArrivee')
//            ->add('villea',new VillesForm())
//            ->add('villea',new VillesForm())


        ;
    }

    public function getName() {
        return 'Covoiturages';
    }

}

?>
