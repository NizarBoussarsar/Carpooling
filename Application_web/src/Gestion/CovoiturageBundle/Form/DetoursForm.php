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
 * Description of DetoursForm
 *
 * @author Hhussein
 */
class DetoursForm extends AbstractType {
       public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
                ->add('id_covoiturage')
                ->add('id_ville')
             
        ;
    }

    public function getName() {
        return 'Detours';
    }
}

?>
