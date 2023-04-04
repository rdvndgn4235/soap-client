package com.rd.soapservice;

import com.rd.soapservice.schemas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.soap.SoapMessage;

import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

/**
 * Created at 15.03.2023
 *
 * @author Rıdvan DOĞAN
 */
@RestController
@RequestMapping("api/v1/")
public class SoapRequestController {

    private SOAPConnector soapConnector;

    @Autowired
    public SoapRequestController(SOAPConnector soapConnector) {
        this.soapConnector = soapConnector;
    }

    @GetMapping
    public ResponseEntity<String> getHelloWorld() {
        String body = "Hello man !!";
        return ResponseEntity.ok().body(body);
    }

    private void proxyInfos() {
        System.setProperty("java.net.useSystemProxies", "true");
        System.out.println("detecting proxies");
        List l = null;
        try {
            l = ProxySelector.getDefault().select(new URI("http://foo/bar"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (l != null) {
            for (Iterator iter = l.iterator(); iter.hasNext(); ) {
                java.net.Proxy proxy = (java.net.Proxy) iter.next();
                System.out.println("proxy type: " + proxy.type());

                InetSocketAddress addr = (InetSocketAddress) proxy.address();

                if (addr == null) {
                    System.out.println("No Proxy");
                } else {
                    System.out.println("proxy hostname: " + addr.getHostName());
                    System.setProperty("http.proxyHost", addr.getHostName());
                    System.out.println("proxy port: " + addr.getPort());
                    System.setProperty("http.proxyPort", Integer.toString(addr.getPort()));
                }
            }
        }
    }

    @GetMapping("seriList")
    public ResponseEntity<String> getSoapSeriListResponse() {
        try {
            proxyInfos();
            Serilist request = new Serilist();
            request.setKullanici("ksserviceadmin");
            request.setSifre("1");
            SerilistResponse response = (SerilistResponse) soapConnector.callWebService("https://ayt.foreks.com/daysisservice.asmx", request,
                    message -> ((SoapMessage) message).setSoapAction("http://tempuri.org/serilist"));
            return ResponseEntity.ok().body(response.getSerilistResult());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error Occurred : " + e.getMessage());
        }
    }

    @GetMapping("evrakTipleri")
    public ResponseEntity<String> getSoapEvrakTipleriResponse() {
        try {
            proxyInfos();
            Evraktipleri request = new Evraktipleri();
            request.setKullanici("ksserviceadmin");
            request.setSifre("1");
            EvraktipleriResponse response = (EvraktipleriResponse) soapConnector.callWebService("https://ayt.foreks.com/daysisservice.asmx", request,
                    message -> ((SoapMessage) message).setSoapAction("http://tempuri.org/evraktipleri"));
            return ResponseEntity.ok().body(response.getEvraktipleriResult());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error Occurred : " + e.getMessage());
        }
    }

    @GetMapping("evraktipalanlari")
    public ResponseEntity<String> getSoapEvrakTipAlanlariResponse() {
        try {
            proxyInfos();
            Evraktipalanlari request = new Evraktipalanlari();
            request.setTipadi("Nüfus Cüzdanı Fotokopisi");
            request.setKullanici("ksserviceadmin");
            request.setSifre("1");
            EvraktipalanlariResponse response = (EvraktipalanlariResponse) soapConnector.callWebService("https://ayt.foreks.com/daysisservice.asmx", request,
                    message -> ((SoapMessage) message).setSoapAction("http://tempuri.org/evraktipalanlari"));
            return ResponseEntity.ok().body(response.getEvraktipalanlariResult());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error Occurred : " + e.getMessage());
        }
    }
}
