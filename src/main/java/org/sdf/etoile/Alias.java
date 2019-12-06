/*
 * Copyright(C) 2019. See COPYING for more.
 */
package org.sdf.etoile;

/**
 * Alias.
 *
 * @since 0.4.0
 */
interface Alias {
    /**
     * Reference of alias.
     * @return Column or expression for alias.
     */
    String reference();

    /**
     * Alias.
     * @return Name of alias.
     */
    String alias();
}
