package org.danix.javaconda.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.danix.javaconda.SpringProfiles;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@Component
@Profile({SpringProfiles.DEV})
public final class MockedServices {

    @PostConstruct
    public void startServer() {
        final WireMockConfiguration options = options()
                .port(8089)
                .usingFilesUnderClasspath("stubs");
        final WireMockServer wireMockServer = new WireMockServer(options);
        wireMockServer.start();
        WireMock.configureFor("localhost", 8089);
    }
}
