package com.acme.craft.fixme.solid.single.responsibility.modem;

interface ModemController extends ModemFileTransfer {
	void dial(String pno);

	void hangup();
}
