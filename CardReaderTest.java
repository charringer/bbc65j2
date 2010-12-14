
public class CardReaderTest extends Assert {

	private CardReader<CF2> cf2r;
	private CardReader<CF1> cf1r;
	private CardReader<SD>  sdr;
	private CardReader<MiniSD> msdr;
	private CardReader<MicroSD> usdr;
	private CardReader<MemoryStick> msr;
	
	private CF2 cf2;
	private CF1 cf1;
	private SD sd;
	private MiniSD msd;
	private MicroSD usd;
	private MemoryStick ms;
	
	private boolean visitCalled;
	
	@Before
	public void setUp() {
		cf1r = new CardReader<CF1>();
		cf2r = new CardReader<CF2>();
		sdr = new CardReader<SD>();
		msdr = new CardReader<MiniSD>();
		usdr = new CardReader<MicroSD>();
		msr = new CardReader<MemoryStick>();
		
		cf1 = new CF1("cf1");
		cf2 = new CF2("cf2");
		sd = new SD("sd");
		msd = new MiniSD("msd");
		usd = new MicroSD("usd");
		ms = new MemoryStick("ms");
		
		visitCalled = false;
	}
	
	@Tst
	public void insert_shouldInsertSmallerCardsIntoLargerSlots() {
		assertTrue(cf2r.insert(cf2));
		assertTrue(cf2r.eject());
		
		assertTrue(cf2r.insert(cf1));
		assertTrue(cf2r.eject());
		
		assertTrue(cf1r.insert(cf1));
		assertTrue(cf1r.eject());
		
		assertTrue(sdr.insert(sd));
		assertTrue(sdr.eject());
		
		assertTrue(sdr.insert(msd));
		assertTrue(sdr.eject());
		
		assertTrue(sdr.insert(usd));
		assertTrue(sdr.eject());
		
		assertTrue(msdr.insert(msd));
		assertTrue(msdr.eject());
		
		assertTrue(msdr.insert(usd));
		assertTrue(msdr.eject());
		
		assertTrue(usdr.insert(usd));
		assertTrue(usdr.eject());
		
		assertTrue(msr.insert(ms));
		assertTrue(msr.eject());
	}
	
	@Tst
	public void insert_shouldNotInsertTwice() {
		cf2r.insert(cf2);
		assertFalse(cf2r.insert(cf2));
	}
	
	@Tst
	public void eject_shouldNotEjectBeforeInsert() {
		assertFalse(cf2r.eject());
	}
	
	@Tst
	public void eject_shouldNotEjectTwice() {
		cf2r.insert(cf2);
		assertTrue(cf2r.eject());
		assertFalse(cf2r.eject());
	}
	
	@Tst
	public void accept_shouldCallVisitVolume() {
		cf2r.insert(cf2);
		cf2r.accept(new AbstractDeviceVisitor() {
			
			@Override
			public void visit(Volume vol) {
				assertEquals(cf2, vol);
				visitCalled = true;
			}
		});
		assertTrue(visitCalled);
	}
	
	@Tst
	public void accept_shouldNotCallVisitVolumeUnlessInserted() {
		cf2r.accept(new AbstractDeviceVisitor() {
			
			@Override
			public void visit(Volume vol) {
				assertFalse(true);
			}
		});
	}
}
