package liste;

public class ListeSimple {
    private long size;
    Noeud tete;

    /**
     * @return the number of elements in the list
     */
    public long getSize() {
        return size;
    }

    /**
     * Adds a new node with the specified element to the front of the list.
     *
     * @param element the element to be added
     */
    public void ajout(int element) {
        // Create a new node with the given element and set it as the new head
        tete = new Noeud(element, tete);
        // Increment the size of the list
        size++;
    }

    /**
     * Modifies the first node in the list that contains the specified element.
     * 
     * @param element the element to be replaced
     * @param nouvelleValeur the new value to set
     */
    public void modifiePremier(Object element, Object nouvelleValeur) {
        // Loop through the list until the element is found
        Noeud courant = tete;
        while (courant != null && courant.getElement() != element)
            courant = courant.getSuivant();
        // If the element is found, update its value
        if (courant != null)
            courant.setElement(nouvelleValeur);
    }

    /**
     * Modifies all nodes in the list that contain the specified element.
     * 
     * @param element the element to be replaced
     * @param nouvelleValeur the new value to set
     */
    public void modifieTous(Object element, Object nouvelleValeur) {
        Noeud courant = tete; // Start from the head of the list
        while (courant != null) { // Traverse the entire list
            if (courant.getElement() == element) // Check if the current node has the desired element
                courant.setElement(nouvelleValeur); // Update the element of the node
            courant = courant.getSuivant(); // Move to the next node
        }
    }

    /**
     * Returns a string representation of the list.
     * 
     * @return a string representation of the list
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("ListeSimple(");
        // Loop through the list
        Noeud n = tete;
        while (n != null) {
            // Append the current node to the string
            sb.append(n);
            // Get the next node
            n = n.getSuivant();
            // If there is a next node, add a comma
            if (n != null)
                sb.append(", ");
        }
        // Close the parentheses
        sb.append(")");
        // Return the string
        return sb.toString();
    }

    /**
     * Removes the first occurrence of a node with the specified element from the list.
     * 
     * @param element the element to be removed
     */
    public void supprimePremier(Object element) {
        // Check if the list is not empty
        if (tete != null) {
            // Check if the head node contains the element
            if (tete.getElement() == element) {
                // Remove the head node by updating the head to the next node
                tete = tete.getSuivant();
                size--;
                return;
            }
            // Initialize pointers for traversal
            Noeud precedent = tete;
            Noeud courant = tete.getSuivant();
            
            // Traverse the list to find the node with the element
            while (courant != null && courant.getElement() != element) {
                precedent = precedent.getSuivant();
                courant = courant.getSuivant();
            }
            
            // If the node is found, remove it by updating the predecessor's link
            if (courant != null) {
                precedent.setSuivant(courant.getSuivant());
                size--;
            }
        }
    }

    /**
     * Removes all nodes with the specified element from the list.
     * 
     * @param element the element to be removed
     */
    public void supprimeTous(int element) {
        // Update the head of the list after removing the elements
        tete = supprimeTousRecurs(element, tete);
    }

    /**
     * Recursively removes all nodes with the specified element from the list.
     * 
     * @param element the element to be removed
     * @param tete the head node of the list
     * @return the head of the modified list
     */
    public Noeud supprimeTousRecurs(Object element, Noeud tete) {
        if (tete != null) {
            // Recursively process the next node
            Noeud suiteListe = supprimeTousRecurs(element, tete.getSuivant());
            
            // If the current node contains the element, skip it
            if (tete.getElement() == element) {
                size--;
                return suiteListe;
            } else {
                // Otherwise, link it to the processed list
                tete.setSuivant(suiteListe);
                return tete;
            }
        } else {
            // Base case: end of the list
            return null;
        }
    }

    /**
     * Retrieves the second to last node in the list.
     * 
     * @return the penultimate node, or null if the list has less than two nodes
     */
    public Noeud getAvantDernier() {
        // Check if the list is empty or has only one node
        if (tete == null || tete.getSuivant() == null)
            return null;

        // Initialize pointers for traversal
        Noeud courant = tete;
        Noeud suivant = courant.getSuivant();

        // Traverse until the node before the last node
        while (suivant.getSuivant() != null) {
            courant = suivant;
            suivant = suivant.getSuivant();
        }

        // Return the second to last node
        return courant;
    }

    /**
     * Reverses the linked list.
     * This method iterates over the list and reverses the direction of the links
     * between the nodes, effectively reversing the entire list.
     */
    public void inverser() {
        Noeud precedent = null;  // Initialize the previous node as null
        Noeud courant = tete;    // Start with the head of the list
        while (courant != null) {
            Noeud next = courant.getSuivant(); // Store the next node
            courant.setSuivant(precedent);     // Reverse the link
            precedent = courant;               // Move the previous node forward
            courant = next;                    // Move the current node forward
        }
        tete = precedent;  // Update the head to be the last node visited
    }

    /**
     * Returns the node preceding the given node in the list, or null if the
     * given node is the head of the list.
     * 
     * @param r the node to find the predecessor for
     * @return the predecessor of r, or null if r is the head of the list
     */
    public Noeud getPrecedent(Noeud r) {
        // the list is not empty because we transmit a node of the list and the node
        // exists necessarily
        Noeud precedent = tete;
        Noeud courant = precedent.getSuivant();
        while (courant != r) {
            precedent = courant;
            courant = courant.getSuivant();
        }
        return precedent;
    }

    /**
     * Swap the two nodes in the list.
     * <p>
     * If either or both of the nodes are null, or if the two nodes are the same
     * node, this method does nothing.
     * 
     * @param r1 the first node to swap
     * @param r2 the second node to swap
     */
    public void echanger(Noeud r1, Noeud r2) {
        if (r1 == r2 || r1 == null || r2 == null)
            return;

        // Find the predecessors of the two nodes
        Noeud precedentR1 = r1 != tete ? getPrecedent(r1) : null;
        Noeud precedentR2 = r2 != tete ? getPrecedent(r2) : null;

        // Handle the case where either of the nodes is the head of the list
        if (r1 == tete)
            tete = r2;
        else if (r2 == tete)
            tete = r1;
        
        // Update the predecessors
        if (precedentR1 != null)
            precedentR1.setSuivant(r2);
        
        if (precedentR2 != null)
            precedentR2.setSuivant(r1);
    
        // Update the successors
        Noeud temp = r1.getSuivant();
        r1.setSuivant(r2.getSuivant());
        r2.setSuivant(temp);
    }
}
