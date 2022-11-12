# JavaSockets
Simple client-server architecture using Java Sockets and multithreading ops

-- OBS! Created Human as abstract class rather than interface because requirement was to sort the collection of persons registered in the connection by age, and since entities 'Student' and 'Profesor' share a lot of fields, including age, they need to extend the abstract class Human which implements the Comparable<T> interface for comparing entities by age, that way polymorphism is preserved and each thread will have a single collection List<Human> that is going to be sorted. If 'Human' was interface, both Student and Profesor would implement it but one will not be able to compare a Student to a Profesor by age when sorting the collection in the thread. :D
