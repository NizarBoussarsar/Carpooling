<?php

namespace Front\MNRSBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class MessagesType extends AbstractType
{
        /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('objet')
            ->add('contenu')
            ->add('dateEnvoie')
            ->add('lu')
            ->add('idExpediteur')
            ->add('idDestinataire')
        ;
    }
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Front\MNRSBundle\Entity\Messages'
        ));
    }

    /**
     * @return string
     */
    public function getName()
    {
        return 'front_mnrsbundle_messages';
    }
}
