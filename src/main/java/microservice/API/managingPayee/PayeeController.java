package microservice.API.managingPayee;

import microservice.Common.managingPayee.ReadCommand.FindPayee;
import microservice.Common.managingPayee.Views.PayeeView;
import microservice.Common.managingPayee.WriteCommand.AddingPayee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PayeeController {

    @RequestMapping(value = { "/create", "/" }, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody AddingPayee e) {
        //employeeService.create(e);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<FindPayee>> findById(@PathVariable("id") Integer id) {
        /*Mono<Employee> e = employeeService.findById(id);
        HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;*/
        return null;//new ResponseEntity<Mono<Employee>>(e, status);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Flux<PayeeView> findByName(@PathVariable("name") String name) {

        return null;//employeeService.findByName(name);
    }
}
