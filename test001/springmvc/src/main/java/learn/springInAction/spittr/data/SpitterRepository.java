package learn.springInAction.spittr.data;

import learn.springInAction.spittr.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
