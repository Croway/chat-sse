package it.croway;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.core.Vertx;

@Path("chat")
public class ChatResource {

    @Inject
    Vertx vertx;

    @POST
    @Path("message")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMessage(Message message) {
        vertx.eventBus().publish(message.getChat(), message.getMessage());
    }

    @GET
    @Path("{chat}")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<String> getMessage(@PathParam("chat") String chat) {
        return vertx.eventBus().consumer(chat).toMulti()
                .map(l -> String.format("from event bus: %s", l.body().toString()));
    }

}