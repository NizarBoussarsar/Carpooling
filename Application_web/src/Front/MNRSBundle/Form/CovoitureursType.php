<?php

namespace Front\MNRSBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class CovoitureursType extends AbstractType
{
        /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('email')
            ->add('mdp')
            ->add('nomUtilisateur')
            ->add('nom')
            ->add('prenom')
            ->add('sexe')
            ->add('fumeur')
            ->add('dateNaissance')
            ->add('dateEnregistrement')
            ->add('note')
            ->add('etat')
            ->add('avatar')
            ->add('skype')
            ->add('facebook')
            ->add('dateDerniereVisite')
            ->add('cleActivation')
            ->add('idFacebook')
            ->add('latitude')
            ->add('longitude')
            ->add('connecte')
        ;
    }
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Front\MNRSBundle\Entity\Covoitureurs'
        ));
    }

    /**
     * @return string
     */
    public function getName()
    {
        return 'front_mnrsbundle_covoitureurs';
    }
}
