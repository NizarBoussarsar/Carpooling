<?php
namespace Gestion\CovoiturageBundle\Controller;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of ParticipantsController
 *
 * @author Hhussein
 */
class ParticipantsController extends Controller{
    
    
  public function ListParticipantsAction() {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('FrontMNRSBundle:Participants')->findAll();

        return $this->render('GestionCovoiturageBundle:Participants:index.html.twig', array(
                    'entities' => $entities,
        ));
    }
    public function deleteParticipantsAction($id) {

        $em = $this->getDoctrine()->getManager();
        $entity = $em->getRepository('FrontMNRSBundle:Participants')->findByidCovoiturage($id);
        


     if ($entity){   
      for ($index = 0; $index < count($entity); $index++) {
        $em->remove($entity[$index]);
        $em->flush();
     }}
          
    return $this->redirect($this->generateUrl('Mes_covoiturages'));
     
     }
}

?>
