package org.graylog.snmp;

import com.google.inject.Scopes;
import org.graylog.snmp.codec.SnmpCodec;
import org.graylog.snmp.input.SnmpUDPInput;
import org.graylog.snmp.oid.SnmpMibsLoaderRegistry;
import org.graylog2.plugin.PluginConfigBean;
import org.graylog2.plugin.PluginModule;

import java.util.Collections;
import java.util.Set;

/**
 * Extend the PluginModule abstract class here to add you plugin to the system.
 */
public class SnmpPluginModule extends PluginModule {
    /**
     * Returns all configuration beans required by this plugin.
     *
     * Implementing this method is optional. The default method returns an empty {@link Set}.
     */
    @Override
    public Set<? extends PluginConfigBean> getConfigBeans() {
        return Collections.emptySet();
    }

    @Override
    protected void configure() {
        addMessageInput(SnmpUDPInput.class);
        addCodec("snmp", SnmpCodec.class);

        bind(SnmpMibsLoaderRegistry.class).in(Scopes.SINGLETON);
    }
}
